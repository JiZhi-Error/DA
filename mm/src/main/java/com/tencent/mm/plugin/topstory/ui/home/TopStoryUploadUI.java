package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;

public class TopStoryUploadUI extends MMActivity implements i {
    public static c Glu;
    private long EPV = 0;
    private TextView GlA;
    private TextView GlB;
    private TextView GlC;
    private SnsEditText GlD;
    private TextView GlE;
    private boolean GlF = false;
    private String Glv;
    private String Glw;
    private ImageView Glx;
    private ImageView Gly;
    private TextView Glz;
    private String appVersion;
    private String businessType;
    private String dNI;
    private String desc;
    private String extInfo;
    private TextView hXK;
    private com.tencent.mm.pluginsdk.ui.span.i ptq = new com.tencent.mm.pluginsdk.ui.span.i() {
        /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass4 */

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object a(u uVar) {
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object b(u uVar) {
            AppMethodBeat.i(126040);
            h.INSTANCE.a(17080, 5, 2, TopStoryUploadUI.this.dNI);
            AppMethodBeat.o(126040);
            return null;
        }
    };
    private View pwD;
    private String thumbUrl;
    protected q tipDialog = null;
    private String title;
    private int type;
    private TextView xAS;
    private View xgq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryUploadUI() {
        AppMethodBeat.i(126043);
        AppMethodBeat.o(126043);
    }

    static /* synthetic */ void a(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(126054);
        topStoryUploadUI.exit();
        AppMethodBeat.o(126054);
    }

    static /* synthetic */ void b(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(126055);
        topStoryUploadUI.fyv();
        AppMethodBeat.o(126055);
    }

    static /* synthetic */ void i(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(126057);
        topStoryUploadUI.wt(false);
        AppMethodBeat.o(126057);
    }

    static {
        AppMethodBeat.i(126058);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        aVar.iaT = false;
        aVar.jbq = R.color.u6;
        Glu = aVar.bdv();
        AppMethodBeat.o(126058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c4f;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126044);
        Log.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
        super.onCreate(bundle);
        setMMTitle(R.string.hqy);
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126041);
                if (TopStoryUploadUI.this.isFinishing()) {
                    AppMethodBeat.o(126041);
                    return false;
                } else if (System.currentTimeMillis() - TopStoryUploadUI.this.EPV < 500) {
                    AppMethodBeat.o(126041);
                    return false;
                } else {
                    h.INSTANCE.a(17080, 4, 2, TopStoryUploadUI.this.dNI);
                    TopStoryUploadUI.this.EPV = System.currentTimeMillis();
                    String obj = TopStoryUploadUI.this.GlD.getText().toString();
                    if (obj.length() > 200) {
                        com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(R.string.hc2), "", true);
                        AppMethodBeat.o(126041);
                        return true;
                    } else if (!TopStoryUploadUI.dzA()) {
                        com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(R.string.dep), "", true);
                        e.INSTANCE.idkeyStat(1032, 1, 1, false);
                        AppMethodBeat.o(126041);
                        return true;
                    } else {
                        TopStoryUploadUI.this.a(System.currentTimeMillis(), TopStoryUploadUI.this.extInfo, obj, TopStoryUploadUI.fyu(), com.tencent.mm.pluginsdk.model.app.h.o(TopStoryUploadUI.this.dNI, true, false), TopStoryUploadUI.this.appVersion);
                        AppMethodBeat.o(126041);
                        return true;
                    }
                }
            }
        }, null, t.b.YELLOW);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126037);
                TopStoryUploadUI.a(TopStoryUploadUI.this);
                AppMethodBeat.o(126037);
                return true;
            }
        });
        g.azz().a(2534, this);
        this.type = getIntent().getIntExtra("KEY_TYPE", 0);
        this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
        this.dNI = getIntent().getStringExtra("KEY_APPID");
        this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
        this.title = getIntent().getStringExtra("KEY_TITLE");
        this.desc = getIntent().getStringExtra("KEY_DESC");
        this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
        this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
        this.Glv = getIntent().getStringExtra("KEY_MEDIANAME");
        this.Glw = getIntent().getStringExtra("KEY_MEDIAHEADURL");
        this.xgq = findViewById(R.id.j58);
        this.Glx = (ImageView) findViewById(R.id.j57);
        this.xAS = (TextView) findViewById(R.id.j6t);
        this.Glz = (TextView) findViewById(R.id.j4d);
        this.GlD = (SnsEditText) findViewById(R.id.b9k);
        this.GlE = (TextView) findViewById(R.id.ea1);
        this.hXK = (TextView) findViewById(R.id.jog);
        this.GlA = (TextView) findViewById(R.id.joh);
        this.pwD = findViewById(R.id.s8);
        this.Gly = (ImageView) findViewById(R.id.s7);
        this.GlB = (TextView) findViewById(R.id.s9);
        this.GlC = (TextView) findViewById(R.id.s6);
        if (this.type == 1) {
            this.xgq.setVisibility(0);
            this.pwD.setVisibility(8);
            this.xAS.setText(this.title);
            this.Glz.setText(this.Glv);
            com.tencent.mm.av.q.bcV().a(this.thumbUrl, this.Gly, Glu, new com.tencent.mm.av.a.c.h() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass2 */

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, b bVar) {
                    AppMethodBeat.i(126038);
                    if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                        Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
                        AppMethodBeat.o(126038);
                    } else if (Util.isNullOrNil(str)) {
                        Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
                        AppMethodBeat.o(126038);
                    } else if (!(view instanceof ImageView)) {
                        Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
                        AppMethodBeat.o(126038);
                    } else {
                        if (bVar.bitmap.getWidth() < bVar.bitmap.getHeight()) {
                            ((ImageView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
                        } else {
                            ((ImageView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                        AppMethodBeat.o(126038);
                    }
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, b bVar) {
                }
            });
        } else {
            this.xgq.setVisibility(8);
            this.pwD.setVisibility(0);
            this.GlB.setText(this.title);
            this.GlC.setText(this.Glv);
            com.tencent.mm.av.q.bcV().a(this.thumbUrl, this.Gly, Glu);
        }
        this.GlE.setText(String.format("<a href='%s'>%s</a>", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2a) + "/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(R.string.hqw)));
        l.p(this.GlE, 1);
        l.a(this.ptq);
        fyv();
        this.GlD.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(126039);
                TopStoryUploadUI.b(TopStoryUploadUI.this);
                TopStoryUploadUI.c(TopStoryUploadUI.this);
                AppMethodBeat.o(126039);
            }
        });
        h.INSTANCE.a(17080, 6, 1, this.dNI);
        AppMethodBeat.o(126044);
    }

    protected static boolean dzA() {
        boolean z;
        AppMethodBeat.i(126045);
        if (g.aAe().azG().aBb()) {
            int aYS = g.azz().aYS();
            if (aYS == 4 || aYS == 6) {
                AppMethodBeat.o(126045);
                return true;
            }
            AppMethodBeat.o(126045);
            return false;
        }
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(126045);
            return true;
        }
        AppMethodBeat.o(126045);
        return false;
    }

    private void exit() {
        AppMethodBeat.i(126046);
        h.INSTANCE.a(17080, 3, 2, this.dNI);
        if (this.GlD.getText().toString().length() > 0) {
            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.hqu, 0, (int) R.string.a0_, (int) R.string.x6, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(126042);
                    TopStoryUploadUI.i(TopStoryUploadUI.this);
                    AppMethodBeat.o(126042);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, (int) R.color.g7);
            AppMethodBeat.o(126046);
            return;
        }
        wt(false);
        AppMethodBeat.o(126046);
    }

    private void wt(boolean z) {
        AppMethodBeat.i(126047);
        if (z) {
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, (Object) 110);
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 1);
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(this.dNI, true, false);
            WXOpenBusinessView.Resp resp = new WXOpenBusinessView.Resp();
            resp.extMsg = "";
            resp.errStr = "";
            resp.openId = o.field_openId;
            resp.errCode = 0;
            resp.businessType = this.businessType;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            bundle.putString("_openbusinessview_app_name", o.field_appName);
            bundle.putString("_openbusinessview_package_name", o.field_packageName);
            com.tencent.mm.plugin.topstory.ui.c.a(this, 54, bundle, "");
        } else {
            n.d(this.businessType, "", this.dNI, 0, "");
        }
        finish();
        this.GlF = true;
        AppMethodBeat.o(126047);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(126048);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.topstory.a.c.g) {
                BaseResponse baseResponse = ((abw) ((com.tencent.mm.plugin.topstory.a.c.g) qVar).rr.iLL.iLR).BaseResponse;
                if (baseResponse.Ret == 0) {
                    wt(true);
                    AppMethodBeat.o(126048);
                    return;
                } else if (baseResponse.ErrMsg == null || Util.isNullOrNil(baseResponse.ErrMsg.MTo)) {
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.hqx), getString(R.string.hqv), true);
                } else {
                    com.tencent.mm.ui.base.h.c(this, baseResponse.ErrMsg.MTo, getString(R.string.hqv), true);
                }
            }
        } else if (Util.isNullOrNil(str)) {
            com.tencent.mm.ui.base.h.c(this, getString(R.string.hpy), getString(R.string.hqv), true);
        } else {
            com.tencent.mm.ui.base.h.c(this, str, getString(R.string.hqv), true);
        }
        e.INSTANCE.idkeyStat(1032, 2, 1, false);
        AppMethodBeat.o(126048);
    }

    public static String fyu() {
        AppMethodBeat.i(126049);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        String sb2 = sb.append(p.getString(a.getUin())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(126049);
        return sb2;
    }

    public final int a(long j2, String str, String str2, String str3, com.tencent.mm.pluginsdk.model.app.g gVar, String str4) {
        AppMethodBeat.i(126050);
        g.azz().a(new com.tencent.mm.plugin.topstory.a.c.g(j2, str, str2, str3, gVar, str4), 0);
        getString(R.string.zb);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.hqz), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(126050);
        return 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(126051);
        Log.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        l.b(this.ptq);
        g.azz().b(2534, this);
        if (!this.GlF) {
            h.INSTANCE.a(17080, 3, 2, this.dNI);
        }
        AppMethodBeat.o(126051);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(126052);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            exit();
            AppMethodBeat.o(126052);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(126052);
        return dispatchKeyEvent;
    }

    private void fyv() {
        int color;
        AppMethodBeat.i(126053);
        int length = this.GlD.getText().toString().length();
        if (length < 180) {
            this.hXK.setVisibility(8);
            this.GlA.setVisibility(8);
            AppMethodBeat.o(126053);
            return;
        }
        this.hXK.setVisibility(0);
        this.GlA.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(R.color.ac4);
        } else {
            color = getResources().getColor(R.color.a5c);
        }
        this.hXK.setText(String.valueOf(length));
        this.hXK.setTextColor(color);
        AppMethodBeat.o(126053);
    }

    static /* synthetic */ void c(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(126056);
        if (topStoryUploadUI.GlD.getText().toString().length() <= 200) {
            topStoryUploadUI.enableOptionMenu(0, true);
            AppMethodBeat.o(126056);
            return;
        }
        topStoryUploadUI.enableOptionMenu(0, false);
        AppMethodBeat.o(126056);
    }
}
