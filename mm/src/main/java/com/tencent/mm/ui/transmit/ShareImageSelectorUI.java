package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements AdapterView.OnItemClickListener {
    private static int QAo = 1;
    private int PYv = 2;
    private a QAp;
    private Dialog QAq;
    private View.OnClickListener QAr = new View.OnClickListener() {
        /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(39454);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/ShareImageSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ShareImageSelectorUI.a(ShareImageSelectorUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39454);
        }
    };
    private String QxF;
    private ImageView cIN;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(39455);
            ShareImageSelectorUI.this.finish();
            AppMethodBeat.o(39455);
        }
    };
    private ListView mListView;
    private View rhx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareImageSelectorUI() {
        AppMethodBeat.i(39464);
        AppMethodBeat.o(39464);
    }

    static /* synthetic */ void b(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39476);
        shareImageSelectorUI.edw();
        AppMethodBeat.o(39476);
    }

    static /* synthetic */ void c(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39477);
        shareImageSelectorUI.gYs();
        AppMethodBeat.o(39477);
    }

    static /* synthetic */ void d(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39478);
        shareImageSelectorUI.gYt();
        AppMethodBeat.o(39478);
    }

    static /* synthetic */ void e(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39479);
        shareImageSelectorUI.gYu();
        AppMethodBeat.o(39479);
    }

    static /* synthetic */ void f(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39480);
        shareImageSelectorUI.gYv();
        AppMethodBeat.o(39480);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bs2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int intValue;
        AppMethodBeat.i(39465);
        super.onCreate(bundle);
        bg.aVF();
        Object obj = c.azQ().get(229635, (Object) null);
        if ((obj instanceof Integer) && ((intValue = ((Integer) obj).intValue()) == 0 || intValue == 1)) {
            QAo = intValue;
        }
        setMMTitle(R.string.f00);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39456);
                ShareImageSelectorUI.b(ShareImageSelectorUI.this);
                AppMethodBeat.o(39456);
                return false;
            }
        });
        this.PYv = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.QxF = getIntent().getStringExtra("intent_extra_image_path");
        this.rhx = findViewById(R.id.f65);
        this.cIN = (ImageView) findViewById(R.id.dup);
        this.cIN.setOnClickListener(this.QAr);
        this.mListView = (ListView) findViewById(R.id.ecm);
        this.QAp = new a();
        this.mListView.setAdapter((ListAdapter) this.QAp);
        this.mListView.setOnItemClickListener(this);
        Log.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new StringBuilder().append(this.PYv).toString(), this.QxF);
        if (QAo == 1) {
            setTitleVisibility(8);
            this.mListView.setVisibility(8);
            this.cIN.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.cIN.setPadding(0, 0, 0, 0);
            this.cIN.setOnClickListener(null);
            this.rhx.setBackgroundColor(getResources().getColor(R.color.kq));
            gYs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap Sq = u.Sq(this.QxF);
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(this.QxF);
        Log.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", Integer.valueOf(exifOrientation));
        Bitmap rotate = BitmapUtil.rotate(Sq, (float) exifOrientation);
        if (rotate != null && !rotate.isRecycled()) {
            this.cIN.setImageBitmap(rotate);
        }
        Log.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", (System.currentTimeMillis() - currentTimeMillis) + "'");
        AppMethodBeat.o(39465);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(39466);
        super.onResume();
        if (QAo == 1 && (this.QAq == null || !this.QAq.isShowing())) {
            gYs();
        }
        AppMethodBeat.o(39466);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(39467);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/ShareImageSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        switch (i2) {
            case 0:
                gYt();
                break;
            case 1:
                gYu();
                break;
            case 2:
                gYv();
                break;
            default:
                Log.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                break;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(39467);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(39468);
        Log.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1001:
                if (i3 == -1) {
                    ArrayList<String> arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", arrayList.get(0));
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    finish();
                    AppMethodBeat.o(39468);
                    return;
                }
                Log.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.o(39468);
                return;
            case 1002:
                if (i3 == -1) {
                    Toast.makeText(getContext(), (int) R.string.b99, 0).show();
                    finish();
                    AppMethodBeat.o(39468);
                    return;
                }
                Log.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.o(39468);
                return;
            default:
                Log.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                AppMethodBeat.o(39468);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(39469);
        edw();
        AppMethodBeat.o(39469);
    }

    private void edw() {
        AppMethodBeat.i(39470);
        h.a((Context) getContext(), getString(R.string.bjx), getString(R.string.bjz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(39457);
                ShareImageSelectorUI.this.finish();
                AppMethodBeat.o(39457);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(39458);
                if (ShareImageSelectorUI.QAo == 1) {
                    ShareImageSelectorUI.c(ShareImageSelectorUI.this);
                }
                AppMethodBeat.o(39458);
            }
        });
        AppMethodBeat.o(39470);
    }

    private void gYs() {
        AppMethodBeat.i(39471);
        if (this.QAq == null || !this.QAq.isShowing()) {
            String[] strArr = {getString(R.string.bk1), getString(R.string.bk2), getString(R.string.bk0)};
            AppCompatActivity context = getContext();
            String string = getString(R.string.f00);
            AnonymousClass6 r4 = new h.d() {
                /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass6 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(39459);
                    switch (i2) {
                        case 0:
                            ShareImageSelectorUI.d(ShareImageSelectorUI.this);
                            AppMethodBeat.o(39459);
                            return;
                        case 1:
                            ShareImageSelectorUI.e(ShareImageSelectorUI.this);
                            AppMethodBeat.o(39459);
                            return;
                        case 2:
                            ShareImageSelectorUI.f(ShareImageSelectorUI.this);
                            break;
                    }
                    AppMethodBeat.o(39459);
                }
            };
            new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.transmit.ShareImageSelectorUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(39460);
                    ShareImageSelectorUI.b(ShareImageSelectorUI.this);
                    AppMethodBeat.o(39460);
                }
            };
            this.QAq = h.c(context, string, strArr, null, r4);
            AppMethodBeat.o(39471);
            return;
        }
        AppMethodBeat.o(39471);
    }

    private void gYt() {
        AppMethodBeat.i(39472);
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.u.PWZ);
        intent.putExtra("titile", getString(R.string.g0));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.QxF);
        startActivityForResult(intent, 1001);
        AppMethodBeat.o(39472);
    }

    private void gYu() {
        AppMethodBeat.i(39473);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.QxF);
        intent.putExtra("need_result", true);
        com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsUploadUI", intent, 1002);
        AppMethodBeat.o(39473);
    }

    private void gYv() {
        AppMethodBeat.i(39474);
        cz czVar = new cz();
        com.tencent.mm.pluginsdk.model.h.a(czVar, 6, this.QxF);
        czVar.dFZ.activity = this;
        czVar.dFZ.dGf = 52;
        EventCenter.instance.publish(czVar);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11048, 3, 0, 0);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
        AppMethodBeat.o(39474);
    }

    class a extends BaseAdapter {
        public C2133a[] QAt = {new C2133a(R.string.bk1, R.raw.share_to_friend_icon), new C2133a(R.string.bk2, R.raw.find_more_friend_photograph_icon), new C2133a(R.string.bk0, R.raw.more_my_favorite)};

        a() {
            AppMethodBeat.i(39461);
            AppMethodBeat.o(39461);
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(39462);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ShareImageSelectorUI.this.getContext()).inflate(R.layout.bs3, (ViewGroup) null);
                bVar = new b(view);
            } else {
                bVar = (b) view.getTag();
            }
            C2133a aVar = this.QAt[i2];
            if (aVar != null) {
                bVar.QAx.setText(aVar.QAu);
                bVar.thK.setImageResource(aVar.QAv);
            }
            AppMethodBeat.o(39462);
            return view;
        }

        /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$a$a  reason: collision with other inner class name */
        class C2133a {
            int QAu;
            int QAv;

            public C2133a(int i2, int i3) {
                this.QAu = i2;
                this.QAv = i3;
            }
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i2) {
            return this.QAt[i2];
        }
    }

    class b {
        TextView QAx;
        MMImageView thK;

        public b(View view) {
            AppMethodBeat.i(39463);
            this.thK = (MMImageView) view.findViewById(R.id.e2f);
            this.QAx = (TextView) view.findViewById(R.id.e3x);
            AppMethodBeat.o(39463);
        }
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(39475);
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.QxF);
        intent.putExtra("show_menu", false);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(shareImageSelectorUI, bl.axQ(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        shareImageSelectorUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(shareImageSelectorUI, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(39475);
    }
}
