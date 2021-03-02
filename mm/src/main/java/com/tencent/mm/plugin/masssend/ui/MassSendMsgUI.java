package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.gcm.Task;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class MassSendMsgUI extends MMActivity implements i {
    private static String zok = "";
    private String filePath;
    private List<String> gxh;
    private TextView hXK;
    private q tipDialog = null;
    private ChatFooter znD;
    private String znF;
    private boolean znG = false;
    private TextView zoj;
    private d zol;
    private b zom;
    private AppPanel.a zon = new AppPanel.a() {
        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass10 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehU() {
            AppMethodBeat.i(26458);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.eyj), 0).show();
            AppMethodBeat.o(26458);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehV() {
            AppMethodBeat.i(26459);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.ey2), 0).show();
            AppMethodBeat.o(26459);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehW() {
            AppMethodBeat.i(26460);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.eyh), 0).show();
            AppMethodBeat.o(26460);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehX() {
            AppMethodBeat.i(26461);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.eya), 0).show();
            AppMethodBeat.o(26461);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehY() {
            AppMethodBeat.i(26462);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.ey2), 0).show();
            AppMethodBeat.o(26462);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void Qj(int i2) {
            AppMethodBeat.i(26463);
            switch (i2) {
                case 1:
                    s.a(MassSendMsgUI.this, 1, 1, 3, 3, (Intent) null);
                    AppMethodBeat.o(26463);
                    return;
                case 0:
                    o oVar = new o(b.aKV());
                    if (oVar.exists() || oVar.mkdirs()) {
                        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
                        Log.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), MassSendMsgUI.this.getContext());
                        if (a2) {
                            MassSendMsgUI.c(MassSendMsgUI.this);
                            break;
                        } else {
                            AppMethodBeat.o(26463);
                            return;
                        }
                    } else {
                        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.b2v), 1).show();
                        AppMethodBeat.o(26463);
                        return;
                    }
            }
            AppMethodBeat.o(26463);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void d(g gVar) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void ehZ() {
            AppMethodBeat.i(26464);
            com.tencent.mm.plugin.masssend.a.jRt.cb(MassSendMsgUI.this);
            AppMethodBeat.o(26464);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eia() {
            AppMethodBeat.i(26465);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.ey2), 0).show();
            AppMethodBeat.o(26465);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eib() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eic() {
            AppMethodBeat.i(26466);
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            c.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            AppMethodBeat.o(26466);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void Qk(int i2) {
            AppMethodBeat.i(26467);
            MassSendMsgUI.a(MassSendMsgUI.this, i2);
            AppMethodBeat.o(26467);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eid() {
            AppMethodBeat.i(26468);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.eyb), 0).show();
            AppMethodBeat.o(26468);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eie() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eif() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eig() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eih() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eii() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eij() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eik() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppPanel.a
        public final void eil() {
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MassSendMsgUI() {
        AppMethodBeat.i(26474);
        AppMethodBeat.o(26474);
    }

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, Intent intent) {
        AppMethodBeat.i(26492);
        massSendMsgUI.aJ(intent);
        AppMethodBeat.o(26492);
    }

    static /* synthetic */ boolean a(MassSendMsgUI massSendMsgUI, String str, String str2) {
        AppMethodBeat.i(26497);
        boolean iE = massSendMsgUI.iE(str, str2);
        AppMethodBeat.o(26497);
        return iE;
    }

    static /* synthetic */ void b(MassSendMsgUI massSendMsgUI, Intent intent) {
        AppMethodBeat.i(26496);
        massSendMsgUI.aL(intent);
        AppMethodBeat.o(26496);
    }

    static /* synthetic */ void c(MassSendMsgUI massSendMsgUI) {
        AppMethodBeat.i(26493);
        massSendMsgUI.dRW();
        AppMethodBeat.o(26493);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String[] split;
        AppMethodBeat.i(26475);
        super.onCreate(bundle);
        bg.azz().a(193, this);
        this.znG = getIntent().getBooleanExtra("mass_send_again", false);
        this.znF = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.znF;
        this.gxh = new ArrayList();
        if (str != null && !str.equals("") && (split = str.split(";")) != null && split.length > 0) {
            this.gxh = Util.stringsToList(split);
        }
        initView();
        AppMethodBeat.o(26475);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26476);
        super.onResume();
        if (this.znD != null) {
            this.znD.setLastText(zok);
            this.znD.a(getContext(), this);
        }
        AppMethodBeat.o(26476);
    }

    public static void aDR(String str) {
        zok = str;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26477);
        bg.azz().b(193, this);
        super.onDestroy();
        if (this.znD != null) {
            this.znD.destroy();
        }
        AppMethodBeat.o(26477);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26478);
        this.znD.a(ChatFooter.h.Pause);
        this.znD.onPause();
        super.onPause();
        AppMethodBeat.o(26478);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6o;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        SpannableString e2;
        boolean z = true;
        AppMethodBeat.i(26479);
        setMMTitle(R.string.eyc);
        this.zoj = (TextView) findViewById(R.id.fau);
        this.hXK = (TextView) findViewById(R.id.fat);
        TextView textView = this.zoj;
        int textSize = (int) this.zoj.getTextSize();
        if (this.gxh == null) {
            e2 = new SpannableString("");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.gxh.size(); i2++) {
                String displayName = aa.getDisplayName(this.gxh.get(i2));
                if (i2 == this.gxh.size() - 1) {
                    sb.append(displayName);
                } else {
                    sb.append(displayName + ",  ");
                }
            }
            e2 = l.e((Context) this, (CharSequence) sb.toString(), textSize);
        }
        textView.setText(e2);
        this.hXK.setText(getResources().getQuantityString(R.plurals.u, this.gxh.size(), Integer.valueOf(this.gxh.size())));
        this.znD = (ChatFooter) findViewById(R.id.ftn);
        ((MassSendLayout) findViewById(R.id.fay)).setPanel(this.znD.getPanel());
        this.znD.setCattingRootLayoutId(R.id.fay);
        this.zom = new b(this, this.znD, this.znF, this.gxh, this.znG);
        this.znD.setFooterEventListener(this.zom);
        this.znD.setSmileyPanelCallback(new d(this));
        ChatFooter chatFooter = this.znD;
        bg.aVF();
        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(18, (Object) -1)).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.setMode(intValue);
        this.znD.setUserName("masssendapp");
        this.znD.Kik.refresh();
        this.znD.Kik.gpS();
        this.znD.Kik.gpT();
        this.znD.Kik.gpU();
        bg.aVF();
        if (((Boolean) com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue()) {
            this.znD.gqF();
            this.znD.gql();
        }
        this.znD.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass9 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(26457);
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i2, i2 + i4);
                if ((MassSendMsgUI.this.zol == null || !MassSendMsgUI.this.zol.isShowing()) && ImgUtil.isImgFile(substring)) {
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(substring, 300, 300, false);
                    if (extractThumbNail == null) {
                        Log.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        AppMethodBeat.o(26457);
                        return;
                    }
                    ImageView imageView = new ImageView(MassSendMsgUI.this);
                    imageView.setImageBitmap(extractThumbNail);
                    int dimensionPixelSize = MassSendMsgUI.this.getResources().getDimensionPixelSize(R.dimen.hs);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    MassSendMsgUI.this.zol = h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.b2l), imageView, MassSendMsgUI.this.getString(R.string.x_), MassSendMsgUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass9.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26456);
                            Intent intent = new Intent();
                            intent.putExtra("CropImage_OutputPath", substring);
                            MassSendMsgUI.a(MassSendMsgUI.this, intent);
                            AppMethodBeat.o(26456);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    String str = valueOf.substring(0, i2) + valueOf.substring(i2 + i4);
                    MassSendMsgUI.this.znD.z(str, -1, false);
                    String unused = MassSendMsgUI.zok = str;
                }
                AppMethodBeat.o(26457);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.znD.Kik.gpP();
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.aX(true, true);
        this.znD.gqB();
        this.znD.zY(true);
        this.znD.setAppPanelListener(this.zon);
        ChatFooter chatFooter2 = this.znD;
        c.gsX();
        if (!com.tencent.mm.aw.b.bdC()) {
            z = false;
        }
        chatFooter2.zZ(z);
        this.znD.Kik.gpQ();
        this.znD.Kik.gpR();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26446);
                MassSendMsgUI.this.finish();
                AppMethodBeat.o(26446);
                return true;
            }
        });
        AppMethodBeat.o(26479);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(26480);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && this.znD.gqJ()) {
            this.znD.setBottomPanelVisibility(8);
            AppMethodBeat.o(26480);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(26480);
        return onKeyDown;
    }

    private void dRW() {
        AppMethodBeat.i(26481);
        if (!s.d(this, b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.string.gix), 1).show();
        }
        AppMethodBeat.o(26481);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(26482);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(26482);
            return;
        }
        Log.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26469);
                            MassSendMsgUI massSendMsgUI = MassSendMsgUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(massSendMsgUI, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            massSendMsgUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(massSendMsgUI, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(26469);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    dRW();
                    AppMethodBeat.o(26482);
                    return;
                }
        }
        AppMethodBeat.o(26482);
    }

    private void aI(Intent intent) {
        AppMethodBeat.i(26483);
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.znm = this.znF;
        aVar.znn = this.gxh.size();
        aVar.filename = stringExtra;
        aVar.zno = intExtra;
        aVar.msgType = 43;
        final f fVar = new f(aVar, this.znG);
        bg.azz().a(fVar, 0);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) context, getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass12 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26470);
                bg.azz().a(fVar);
                AppMethodBeat.o(26470);
            }
        });
        AppMethodBeat.o(26483);
    }

    private void aJ(Intent intent) {
        int i2;
        AppMethodBeat.i(26484);
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra == null) {
            AppMethodBeat.o(26484);
            return;
        }
        if (z.f(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true))) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        com.tencent.mm.plugin.masssend.a.h.ehF();
        com.tencent.mm.plugin.masssend.a.a l = com.tencent.mm.plugin.masssend.a.b.l(stringExtra, this.znF, this.gxh.size(), i2);
        if (l == null) {
            AppMethodBeat.o(26484);
            return;
        }
        final f fVar = new f(l, this.znG, i2);
        bg.azz().a(fVar, 0);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) context, getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass13 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26471);
                bg.azz().a(fVar);
                AppMethodBeat.o(26471);
            }
        });
        AppMethodBeat.o(26484);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26485);
        Log.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(26485);
            return;
        }
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(26485);
                    return;
                }
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra != null && stringArrayListExtra.size() == 1) {
                    Intent intent2 = new Intent();
                    intent2.setData(Uri.parse("file://".concat(String.valueOf(stringArrayListExtra.get(0)))));
                    aK(intent2);
                    AppMethodBeat.o(26485);
                    return;
                }
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    AppMethodBeat.o(26485);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImage_OutputPath", stringArrayListExtra2.get(0));
                intent3.putExtra("CropImage_Compress_Img", intent.getBooleanExtra("CropImage_Compress_Img", true));
                aJ(intent3);
                AppMethodBeat.o(26485);
                return;
            case 2:
                Context applicationContext = getApplicationContext();
                bg.aVF();
                this.filePath = s.h(applicationContext, intent, com.tencent.mm.model.c.aSY());
                if (this.filePath == null) {
                    AppMethodBeat.o(26485);
                    return;
                }
                Intent intent4 = new Intent();
                intent4.putExtra("CropImageMode", 4);
                intent4.putExtra("CropImage_Filter", true);
                intent4.putExtra("CropImage_ImgPath", this.filePath);
                com.tencent.mm.plugin.masssend.a.jRt.a(getContext(), intent4, 4);
                AppMethodBeat.o(26485);
                return;
            case 3:
            default:
                Log.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.o(26485);
                return;
            case 4:
                aJ(intent);
                AppMethodBeat.o(26485);
                return;
            case 5:
                aI(intent);
                AppMethodBeat.o(26485);
                return;
            case 6:
                aK(intent);
                AppMethodBeat.o(26485);
                return;
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(26485);
                    return;
                } else if (intent.getBooleanExtra("from_record", false)) {
                    aI(intent);
                    AppMethodBeat.o(26485);
                    return;
                } else {
                    aK(intent);
                    AppMethodBeat.o(26485);
                    return;
                }
            case 8:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.zsy) {
                        String str = sightCaptureResult.zsG;
                        if (!Util.isNullOrNil(str)) {
                            try {
                                Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", str);
                                com.tencent.mm.plugin.masssend.a.h.ehF();
                                com.tencent.mm.plugin.masssend.a.a l = com.tencent.mm.plugin.masssend.a.b.l(str, this.znF, this.gxh.size(), 0);
                                if (l == null) {
                                    AppMethodBeat.o(26485);
                                    return;
                                }
                                final f fVar = new f(l, this.znG, 0);
                                bg.azz().a(fVar, 0);
                                AppCompatActivity context = getContext();
                                getString(R.string.zb);
                                this.tipDialog = h.a((Context) context, getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass15 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(26473);
                                        bg.azz().a(fVar);
                                        AppMethodBeat.o(26473);
                                    }
                                });
                                AppMethodBeat.o(26485);
                                return;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", e2.getMessage());
                            }
                        }
                        AppMethodBeat.o(26485);
                        return;
                    }
                    Log.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", sightCaptureResult.zsA, sightCaptureResult.zsB);
                    com.tencent.mm.modelvideo.o.bhj();
                    String Qw = t.Qw(sightCaptureResult.zsC);
                    if (!sightCaptureResult.zsA.equals(Qw)) {
                        Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", sightCaptureResult.zsA, Qw);
                        com.tencent.mm.vfs.s.nx(sightCaptureResult.zsA, Qw);
                    }
                    ev(sightCaptureResult.zsC, sightCaptureResult.zsE);
                }
                AppMethodBeat.o(26485);
                return;
            case 9:
                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                intent.putExtra("K_SEGMENTVIDEOPATH", captureVideoNormalModel.videoPath);
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", captureVideoNormalModel.thumbPath);
                if (captureVideoNormalModel != null) {
                    if (captureVideoNormalModel.BOe.booleanValue()) {
                        String str2 = captureVideoNormalModel.thumbPath;
                        if (!Util.isNullOrNil(str2)) {
                            try {
                                Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", str2);
                                com.tencent.mm.plugin.masssend.a.h.ehF();
                                com.tencent.mm.plugin.masssend.a.a l2 = com.tencent.mm.plugin.masssend.a.b.l(str2, this.znF, this.gxh.size(), 0);
                                if (l2 == null) {
                                    AppMethodBeat.o(26485);
                                    return;
                                }
                                final f fVar2 = new f(l2, this.znG, 0);
                                bg.azz().a(fVar2, 0);
                                AppCompatActivity context2 = getContext();
                                getString(R.string.zb);
                                this.tipDialog = h.a((Context) context2, getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass14 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(26472);
                                        bg.azz().a(fVar2);
                                        AppMethodBeat.o(26472);
                                    }
                                });
                                AppMethodBeat.o(26485);
                                return;
                            } catch (Exception e3) {
                                Log.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", e3.getMessage());
                            }
                        }
                        AppMethodBeat.o(26485);
                        return;
                    }
                    Log.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath);
                    String bpb = com.tencent.mm.vfs.s.bpb(captureVideoNormalModel.videoPath);
                    com.tencent.mm.modelvideo.o.bhj();
                    String Qw2 = t.Qw(bpb);
                    if (!captureVideoNormalModel.videoPath.equals(Qw2)) {
                        Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", captureVideoNormalModel.videoPath, Qw2);
                        com.tencent.mm.vfs.s.nx(captureVideoNormalModel.videoPath, Qw2);
                    }
                    ev(bpb, (int) (captureVideoNormalModel.BOd.longValue() / 1000));
                }
                AppMethodBeat.o(26485);
                return;
        }
    }

    private void ev(final String str, final int i2) {
        AppMethodBeat.i(26486);
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass16 */

            public final void onCancel(DialogInterface dialogInterface) {
                cVar.jpO = null;
            }
        });
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(26448);
                VideoTransPara bba = e.baZ().bba();
                cly cly = new cly();
                cly.Mrn = true;
                if (m.a(str, bba, cly, new com.tencent.mm.plugin.mmsight.model.e() {
                    /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.mmsight.model.e
                    public final boolean ehT() {
                        return false;
                    }
                })) {
                    m.b(str, bba, cly, new com.tencent.mm.plugin.mmsight.model.e() {
                        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.mmsight.model.e
                        public final boolean ehT() {
                            return false;
                        }
                    });
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass2.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(26447);
                        MassSendMsgUI.a(MassSendMsgUI.this, str, i2);
                        AppMethodBeat.o(26447);
                    }
                });
                AppMethodBeat.o(26448);
            }
        }, "MassSend_Remux");
        AppMethodBeat.o(26486);
    }

    private void aK(final Intent intent) {
        AppMethodBeat.i(26487);
        if (!ag.dm(this)) {
            h.a(this, (int) R.string.hwn, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26449);
                    MassSendMsgUI.b(MassSendMsgUI.this, intent);
                    AppMethodBeat.o(26449);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(26487);
            return;
        }
        aL(intent);
        AppMethodBeat.o(26487);
    }

    private void aL(Intent intent) {
        AppMethodBeat.i(26488);
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                cVar.jpO = null;
            }
        });
        cVar.a(this, intent, this.znF, new c.a() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass6 */

            @Override // com.tencent.mm.modelvideo.c.a
            public final void c(int i2, final String str, final String str2, final int i3) {
                AppMethodBeat.i(26453);
                Log.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", Integer.valueOf(i2), str, str2);
                if (i2 >= 0 || i2 == -50002) {
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(26452);
                            if (MassSendMsgUI.a(MassSendMsgUI.this, str, str2)) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(26450);
                                        MassSendMsgUI.a(MassSendMsgUI.this, str, i3);
                                        AppMethodBeat.o(26450);
                                    }
                                });
                                AppMethodBeat.o(26452);
                                return;
                            }
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass6.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(26451);
                                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.hwm), 0).show();
                                    if (MassSendMsgUI.this.tipDialog != null) {
                                        MassSendMsgUI.this.tipDialog.dismiss();
                                        MassSendMsgUI.this.tipDialog = null;
                                    }
                                    AppMethodBeat.o(26451);
                                }
                            });
                            AppMethodBeat.o(26452);
                        }
                    }, "MassSend_Remux");
                } else {
                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.hwl), 0).show();
                    if (MassSendMsgUI.this.tipDialog != null) {
                        MassSendMsgUI.this.tipDialog.dismiss();
                        MassSendMsgUI.this.tipDialog = null;
                        AppMethodBeat.o(26453);
                        return;
                    }
                }
                AppMethodBeat.o(26453);
            }
        });
        AppMethodBeat.o(26488);
    }

    private boolean iE(String str, String str2) {
        double d2;
        int i2;
        int i3;
        AppMethodBeat.i(26489);
        boolean is2G = NetStatusUtil.is2G(this);
        int i4 = is2G ? 10485760 : 26214400;
        if (is2G) {
            d2 = 60000.0d;
        } else {
            d2 = 300000.0d;
        }
        int shouldRemuxingVFS = SightVideoJNI.shouldRemuxingVFS(str2, JsApiResumeDownloadTaskForNative.CTRL_INDEX, 500, i4, d2, 1000000);
        Log.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", Integer.valueOf(shouldRemuxingVFS));
        switch (shouldRemuxingVFS) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                AppMethodBeat.o(26489);
                return false;
            case 0:
                com.tencent.mm.modelvideo.o.bhj();
                String Qw = t.Qw(str);
                com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                dVar.setDataSource(str2);
                Log.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", Qw);
                int i5 = Util.getInt(dVar.extractMetadata(18), 0);
                int i6 = Util.getInt(dVar.extractMetadata(19), 0);
                VideoTransPara videoTransPara = new VideoTransPara();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                com.tencent.mm.plugin.sight.base.e.a(str2, pInt, pInt2, pInt3, pInt4, pInt5);
                videoTransPara.duration = pInt.value / 1000;
                videoTransPara.width = pInt2.value;
                videoTransPara.height = pInt3.value;
                videoTransPara.fps = pInt4.value;
                videoTransPara.videoBitrate = pInt5.value;
                VideoTransPara c2 = e.baZ().c(videoTransPara);
                int i7 = com.tencent.mm.plugin.sight.base.c.Dmd;
                Log.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", videoTransPara, c2);
                if (c2 == null) {
                    int i8 = 0;
                    i3 = i6;
                    int i9 = i5;
                    while (true) {
                        if (i8 < 3) {
                            if (i9 % 2 != 0) {
                                i9--;
                            }
                            if (i3 % 2 != 0) {
                                i3--;
                            }
                            if ((i9 < i3 || (i9 > 640 && i3 > 480)) && (i9 > i3 || (i9 > 480 && i3 > 640))) {
                                i9 /= 2;
                                i3 /= 2;
                                i8++;
                            }
                        } else {
                            i3 = i6;
                            i2 = i5;
                        }
                    }
                    i2 = i9;
                } else {
                    i2 = c2.width;
                    i3 = c2.height;
                    i7 = c2.videoBitrate;
                }
                dVar.release();
                int remuxingVFS = SightVideoJNI.remuxingVFS(str2, Qw, i2, i3, i7, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.c.Dme, null, 0, false, 0, 51);
                if (remuxingVFS < 0) {
                    Log.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                    AppMethodBeat.o(26489);
                    return false;
                }
                aDS(Qw);
                com.tencent.mm.modelvideo.o.bhj();
                String Qx = t.Qx(str);
                if (!com.tencent.mm.vfs.s.YS(Qx)) {
                    Log.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", Qx);
                    try {
                        Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(Qw, 1);
                        if (createVideoThumbnail != null) {
                            BitmapUtil.saveBitmapToImage(createVideoThumbnail, 60, Bitmap.CompressFormat.JPEG, Qx, true);
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.MassSendMsgUI", e2, "", new Object[0]);
                        Log.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", e2.getMessage());
                    }
                }
                Log.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", Qw, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(remuxingVFS));
                AppMethodBeat.o(26489);
                return true;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.tencent.mm.modelvideo.o.bhj();
                aDS(t.Qw(str));
                AppMethodBeat.o(26489);
                return true;
            default:
                AppMethodBeat.o(26489);
                return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(26490);
        Log.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.zom != null) {
            b bVar = this.zom;
            if (bVar.tipDialog != null) {
                bVar.tipDialog.dismiss();
                bVar.tipDialog = null;
            }
        }
        if (i2 == 0 && i3 == 0) {
            zok = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            AppMethodBeat.o(26490);
        } else if (i2 == 4 && i3 == -24) {
            Log.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, (int) R.string.ey8, 0).show();
            AppMethodBeat.o(26490);
        } else {
            if (i2 == 2 || i2 == 1 || i2 == 3) {
                this.znD.setLastText(zok);
            }
            com.tencent.mm.plugin.masssend.a.jRu.a(getContext(), i2, i3, str);
            switch (i3) {
                case -71:
                    h.d(this, getString(R.string.eyi, new Object[]{Integer.valueOf(((cmq) ((f) qVar).rr.iLL.iLR).Msd)}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26455);
                            MassSendMsgUI.this.finish();
                            AppMethodBeat.o(26455);
                        }
                    });
                    AppMethodBeat.o(26490);
                    return;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                    Toast.makeText(this, (int) R.string.ey7, 0).show();
                    AppMethodBeat.o(26490);
                    return;
                default:
                    Toast.makeText(this, (int) R.string.gkm, 0).show();
                    AppMethodBeat.o(26490);
                    return;
            }
        }
    }

    private static void aDS(String str) {
        AppMethodBeat.i(26491);
        long boW = com.tencent.mm.vfs.s.boW(str);
        int nullAsNil = Util.nullAsNil((Integer) com.tencent.mm.plugin.report.service.h.a((int) (boW / 1024), new int[]{512, 1024, 2048, 5120, 8192, Task.EXTRAS_LIMIT_BYTES, 15360, 20480}, 247, 255));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(106, (long) nullAsNil, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(106, 246, 1, false);
        Log.d("MicroMsg.MassSendMsgUI", "report video size res : " + nullAsNil + " hadCompress : true fileLen : " + (boW / 1024) + "K");
        AppMethodBeat.o(26491);
    }

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, int i2) {
        AppMethodBeat.i(26494);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "");
        Log.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), massSendMsgUI);
        if (a2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 1);
            SightParams sightParams = new SightParams(1, i2);
            String Qv = t.Qv(massSendMsgUI.znF);
            com.tencent.mm.modelvideo.o.bhj();
            String Qw = t.Qw(Qv);
            com.tencent.mm.modelvideo.o.bhj();
            RecordConfigProvider a3 = RecordConfigProvider.a(Qw, t.Qx(Qv), sightParams.irT, sightParams.irT.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_ignore_remux_without_edit, false)) {
                a3.remuxType = 2;
            }
            boolean a4 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true);
            UICustomParam.a aVar = new UICustomParam.a();
            aVar.apE();
            aVar.apD();
            aVar.dz(true);
            a3.BOn = aVar.gLU;
            if (a4) {
                com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(massSendMsgUI, 9, a3);
                AppMethodBeat.o(26494);
                return;
            }
            s.e(massSendMsgUI, new Intent(), massSendMsgUI.znF);
        }
        AppMethodBeat.o(26494);
    }

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, String str, int i2) {
        AppMethodBeat.i(26495);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.znm = massSendMsgUI.znF;
        aVar.znn = massSendMsgUI.gxh.size();
        aVar.filename = str;
        aVar.zno = i2;
        aVar.videoSource = 2;
        aVar.msgType = 43;
        final f fVar = new f(aVar, massSendMsgUI.znG);
        bg.azz().a(fVar, 0);
        if (massSendMsgUI.tipDialog != null && massSendMsgUI.tipDialog.isShowing()) {
            massSendMsgUI.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(26454);
                    bg.azz().a(fVar);
                    AppMethodBeat.o(26454);
                }
            });
        }
        AppMethodBeat.o(26495);
    }
}
