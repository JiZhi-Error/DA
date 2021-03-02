package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import java.lang.reflect.Field;

public class SettingsRingtoneUI extends MMActivity implements AdapterView.OnItemClickListener, Runnable {
    private RingtoneManager DdK;
    LayoutInflater DdL;
    private int DdM = -1;
    private int DdN = -1;
    private Ringtone DdO;
    private Cursor To;
    private MMHandler mHandler;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(74366);
        super.onCreate(bundle);
        this.mHandler = new MMHandler();
        this.DdL = LayoutInflater.from(this);
        this.DdK = new RingtoneManager((Activity) this);
        this.DdK.setType(2);
        setVolumeControlStream(5);
        this.DdO = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle(R.string.gs3);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74360);
                SettingsRingtoneUI.this.hideVKB();
                SettingsRingtoneUI.this.finish();
                AppMethodBeat.o(74360);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.gpl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String str;
                AppMethodBeat.i(74361);
                SharedPreferences.Editor edit = SettingsRingtoneUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
                String str2 = g.gLX;
                if (SettingsRingtoneUI.this.DdN != 0) {
                    Uri a2 = SettingsRingtoneUI.a(SettingsRingtoneUI.this, SettingsRingtoneUI.this.DdN);
                    Log.d("RingtonePickerActivity", "set ringtone to ".concat(String.valueOf(a2)));
                    if (a2 != null) {
                        str = a2.toString();
                        String a3 = SettingsRingtoneUI.a(SettingsRingtoneUI.this, a2);
                        edit.putString("settings.ringtone.name", a3);
                        Log.d("RingtonePickerActivity", "ringtone name: ".concat(String.valueOf(a3)));
                    } else {
                        str = g.gLX;
                        edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.string.gs2));
                        Log.d("RingtonePickerActivity", "set ringtone follow system");
                    }
                } else {
                    str = g.gLX;
                    edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.string.gs2));
                    Log.d("RingtonePickerActivity", "set ringtone follow system");
                }
                edit.commit();
                g.Ej(str);
                SettingsRingtoneUI.this.finish();
                AppMethodBeat.o(74361);
                return true;
            }
        }, null, t.b.GREEN);
        ListView listView = (ListView) findViewById(R.id.hn3);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.hs);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.To = this.DdK.getCursor();
        listView.setAdapter((ListAdapter) new a(this.To));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String apX = g.apX();
        if (apX != g.gLX) {
            int ringtonePosition = this.DdK.getRingtonePosition(Uri.parse(apX));
            if (ringtonePosition >= 0) {
                i2 = ringtonePosition + 2;
            } else {
                i2 = 1;
            }
            this.DdM = i2;
            if (this.DdM == 1) {
                getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("settings.ringtone.name", getString(R.string.gs2)).commit();
                Log.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.DdN = this.DdM - 1;
        } else {
            this.DdM = 1;
        }
        listView.setItemChecked(this.DdM, true);
        listView.setSelection(this.DdM);
        AppMethodBeat.o(74366);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br6;
    }

    public void run() {
        Ringtone ringtone;
        AppMethodBeat.i(74368);
        if (isFinishing()) {
            AppMethodBeat.o(74368);
            return;
        }
        if (this.DdN == 0) {
            ringtone = this.DdO;
        } else {
            ringtone = this.DdK.getRingtone(this.DdN - 1);
        }
        if (ringtone != null) {
            try {
                ringtone.play();
                AppMethodBeat.o(74368);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("RingtonePickerActivity", e2, "play ringtone error", new Object[0]);
            }
        }
        AppMethodBeat.o(74368);
    }

    class a extends BaseAdapter {
        int count = 0;
        Cursor dIU;
        int padding = 0;

        public a(Cursor cursor) {
            AppMethodBeat.i(74362);
            this.dIU = cursor;
            this.count = cursor.getCount() + 1;
            Log.d("RingtonePickerActivity", "count = " + this.count);
            this.padding = SettingsRingtoneUI.this.getResources().getDimensionPixelSize(R.dimen.ir);
            AppMethodBeat.o(74362);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(74363);
            CheckedTextView checkedTextView = (CheckedTextView) SettingsRingtoneUI.this.DdL.inflate(R.layout.bpl, (ViewGroup) null);
            if (i2 == 0) {
                checkedTextView.setBackgroundResource(R.drawable.qa);
                checkedTextView.setText(R.string.gs2);
            } else {
                checkedTextView.setBackgroundResource(R.drawable.qa);
                checkedTextView.setText(getItem(i2));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(R.drawable.arh);
            AppMethodBeat.o(74363);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(74364);
            if (this.dIU.isClosed() || !this.dIU.moveToPosition(i2 - 1)) {
                AppMethodBeat.o(74364);
                return "";
            }
            String string = this.dIU.getString(this.dIU.getColumnIndex("title"));
            AppMethodBeat.o(74364);
            return string;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(74369);
        this.DdK.stopPreviousRingtone();
        super.onStop();
        AppMethodBeat.o(74369);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74370);
        this.mHandler.removeCallbacks(this);
        if (this.To != null && !this.To.isClosed()) {
            this.To.close();
            this.To = null;
        }
        RingtoneManager ringtoneManager = this.DdK;
        if (ringtoneManager != null) {
            try {
                Field declaredField = ringtoneManager.getClass().getDeclaredField("mActivity");
                com.tencent.mm.plugin.crashfix.c.a.c(declaredField);
                declaredField.setAccessible(true);
                declaredField.set(ringtoneManager, null);
            } catch (IllegalAccessException | NoSuchFieldException e2) {
            }
        }
        super.onDestroy();
        AppMethodBeat.o(74370);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74371);
        if (i2 == 24 || i2 == 25) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(74371);
            return onKeyUp;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74371);
        return onKeyDown;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(74367);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsRingtoneUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.mHandler.removeCallbacks(this);
        this.DdN = i2 - 1;
        this.mHandler.postDelayed(this, 300);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsRingtoneUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74367);
    }

    static /* synthetic */ Uri a(SettingsRingtoneUI settingsRingtoneUI, int i2) {
        AppMethodBeat.i(74372);
        Uri ringtoneUri = settingsRingtoneUI.DdK.getRingtoneUri(i2 - 1);
        AppMethodBeat.o(74372);
        return ringtoneUri;
    }

    static /* synthetic */ String a(SettingsRingtoneUI settingsRingtoneUI, Uri uri) {
        AppMethodBeat.i(74373);
        String title = RingtoneManager.getRingtone(settingsRingtoneUI, uri).getTitle(settingsRingtoneUI);
        AppMethodBeat.o(74373);
        return title;
    }
}
