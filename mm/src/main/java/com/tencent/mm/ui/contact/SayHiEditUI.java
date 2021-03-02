package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

public class SayHiEditUI extends MMActivity implements i {
    private MMEditText PYw;
    private ProgressDialog gtM = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37965);
        super.onCreate(bundle);
        bg.azz().a(30, this);
        setMMTitle(R.string.fa7);
        initView();
        AppMethodBeat.o(37965);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bni;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37966);
        bg.azz().b(30, this);
        super.onDestroy();
        AppMethodBeat.o(37966);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(37967);
        this.PYw = (MMEditText) findViewById(R.id.h_j);
        this.PYw.requestFocus();
        this.PYw.addTextChangedListener(new a((byte) 0));
        this.PYw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.contact.SayHiEditUI.AnonymousClass1 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(169894);
                if (4 == i2 || 66 == keyEvent.getAction()) {
                    SayHiEditUI.a(SayHiEditUI.this);
                    AppMethodBeat.o(169894);
                    return true;
                }
                AppMethodBeat.o(169894);
                return false;
            }
        });
        c.f(this.PYw).aoq(100).a((c.a) null);
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SayHiEditUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37963);
                SayHiEditUI.this.hideVKB();
                SayHiEditUI.a(SayHiEditUI.this);
                AppMethodBeat.o(37963);
                return false;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SayHiEditUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(169895);
                SayHiEditUI.this.finish();
                AppMethodBeat.o(169895);
                return true;
            }
        });
        AppMethodBeat.o(37967);
    }

    /* access modifiers changed from: package-private */
    public static class a implements TextWatcher {
        private boolean hsV;

        private a() {
            this.hsV = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(37964);
            if (this.hsV) {
                AppMethodBeat.o(37964);
                return;
            }
            this.hsV = true;
            d.INSTANCE.au(3, 2, 10);
            AppMethodBeat.o(37964);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(37968);
        Log.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        try {
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            switch (i3) {
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                case -24:
                    Toast.makeText(this, (int) R.string.faa, 0).show();
                    break;
                case -22:
                    Toast.makeText(this, (int) R.string.fa8, 0).show();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                AppMethodBeat.o(37968);
            } else if (i2 == 0 && i3 == 0) {
                h.cD(this, getString(R.string.b99));
                finish();
                AppMethodBeat.o(37968);
            } else if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
                AppMethodBeat.o(37968);
            } else if (i3 != -101 || Util.isNullOrNil(str)) {
                Toast.makeText(this, (int) R.string.fa9, 0).show();
                AppMethodBeat.o(37968);
            } else {
                h.a(this, str, getString(R.string.zb), getString(R.string.x_), (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(37968);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e2.getMessage());
            AppMethodBeat.o(37968);
        }
    }

    static /* synthetic */ void a(SayHiEditUI sayHiEditUI) {
        AppMethodBeat.i(169897);
        d.INSTANCE.au(2, 1, 5);
        String stringExtra = sayHiEditUI.getIntent().getStringExtra("Contact_User");
        int intExtra = sayHiEditUI.getIntent().getIntExtra("Contact_Scene", 18);
        String stringExtra2 = sayHiEditUI.getIntent().getStringExtra(e.d.OyT);
        LinkedList linkedList = new LinkedList();
        linkedList.add(stringExtra);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(intExtra));
        LinkedList linkedList3 = new LinkedList();
        if (!Util.isNullOrNil(stringExtra2)) {
            linkedList3.add(stringExtra2);
        }
        String trim = sayHiEditUI.PYw.getText().toString().trim();
        if (trim.length() > 50) {
            trim = trim.substring(0, 50);
        }
        final aa aaVar = new aa(sayHiEditUI.getContext(), null);
        aaVar.content = trim;
        aaVar.z(linkedList, linkedList2);
        AppCompatActivity context = sayHiEditUI.getContext();
        sayHiEditUI.getString(R.string.zb);
        sayHiEditUI.gtM = h.a((Context) context, sayHiEditUI.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.contact.SayHiEditUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(169896);
                aaVar.gpI();
                AppMethodBeat.o(169896);
            }
        });
        AppMethodBeat.o(169897);
    }
}
