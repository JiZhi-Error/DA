package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.f.c.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpURLConnectionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity {
    private static final String qpO = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
    private long qpP;
    private String qpQ = "com.tencent.qqpimsecure";
    private String qpR = "00B1208638DE0FCD3E920886D658DAF6";
    private String qpS = "11206657";
    private JSONObject qpT;
    private LinearLayout qqO;
    private LinearLayout qqP;
    private LinearLayout qqQ;
    private TextView qqR;
    private LinearLayout qqS;
    private View qqT;
    private View qqU;
    private TextView qqV;
    private TextView qqW;
    private TextView qqX;
    private TextView qqY;
    private TextView qqZ;
    private Button qra;
    private Button qrb;
    private Button qrc;
    private boolean qrd = false;
    private a qre;
    private com.tencent.mm.plugin.f.c.a qrf;
    private q qrg;
    private long qrh = 0;
    private long qri = 0;
    private long qrj = 0;
    private long qrk = 0;
    private long qrl = 0;
    private a.AbstractC1034a qrm = new a.AbstractC1034a() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.f.c.a.AbstractC1034a
        public final void csi() {
            AppMethodBeat.i(231663);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(231662);
                    long nowMilliSecond = Util.nowMilliSecond() - CleanNewUI.this.qrl;
                    CleanNewUI.this.qrg.dismiss();
                    u.cG(CleanNewUI.this, CleanNewUI.this.getString(R.string.b47));
                    CleanNewUI.this.qqX.setText("0 B");
                    CleanNewUI.this.qrb.setEnabled(false);
                    long j2 = d.cyM().qpK - d.cyM().cacheSize;
                    if (j2 < 0) {
                        Log.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", Long.valueOf(j2), Long.valueOf(d.cyM().qpK), Long.valueOf(d.cyM().cacheSize));
                        j2 = 0;
                    }
                    d.cyM().qpK = j2;
                    d.cyM().cacheSize = 0;
                    CleanNewUI.b(CleanNewUI.this, j2);
                    h.INSTANCE.idkeyStat(714, 15, 1, false);
                    Log.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", Long.valueOf(nowMilliSecond), Long.valueOf(d.cyM().cacheSize));
                    AppMethodBeat.o(231662);
                }
            });
            AppMethodBeat.o(231663);
        }
    };
    private a.AbstractC0924a qrn = new a.AbstractC0924a() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.clean.b.a.AbstractC0924a
        public final void fn(int i2, int i3) {
            AppMethodBeat.i(231665);
            if (!CleanNewUI.this.qrd) {
                CleanNewUI.this.fp(i2, i3);
            }
            AppMethodBeat.o(231665);
        }

        @Override // com.tencent.mm.plugin.clean.b.a.AbstractC0924a
        public final void j(final long j2, final long j3, final long j4) {
            AppMethodBeat.i(231666);
            CleanNewUI.this.qrk = Util.nowMilliSecond();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass7.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(231664);
                    CleanNewUI.a(CleanNewUI.this, j2, j3, j4);
                    AppMethodBeat.o(231664);
                }
            });
            h.INSTANCE.idkeyStat(714, 53, 1, false);
            long j5 = CleanNewUI.this.qri - CleanNewUI.this.qrh;
            long j6 = CleanNewUI.this.qrk - CleanNewUI.this.qrj;
            Log.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", Long.valueOf(CleanNewUI.this.qri), Long.valueOf(CleanNewUI.this.qrh), Long.valueOf(j5), Long.valueOf(CleanNewUI.this.qrk), Long.valueOf(CleanNewUI.this.qrj), Long.valueOf(j6), Long.valueOf(j5 + j6));
            h.INSTANCE.a(14556, Integer.valueOf("newui_wxfile".hashCode()), 0, Long.valueOf(CleanNewUI.this.qrh), Long.valueOf(CleanNewUI.this.qri), Long.valueOf(j5));
            h.INSTANCE.a(14556, Integer.valueOf("newui_folder".hashCode()), 0, Long.valueOf(CleanNewUI.this.qrj), Long.valueOf(CleanNewUI.this.qrk), Long.valueOf(j6));
            h.INSTANCE.a(14556, Integer.valueOf("newui_all".hashCode()), 0, 0, 0, Long.valueOf(j5 + j6));
            AppMethodBeat.o(231666);
        }
    };
    private IListener<mj> qro = new IListener<mj>() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass8 */

        {
            AppMethodBeat.i(231667);
            this.__eventId = mj.class.getName().hashCode();
            AppMethodBeat.o(231667);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mj mjVar) {
            AppMethodBeat.i(231668);
            mj mjVar2 = mjVar;
            if (mjVar2 == null || mjVar2.dRJ == null) {
                AppMethodBeat.o(231668);
            } else {
                Log.i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.a(CleanNewUI.this), Long.valueOf(mjVar2.dRJ.progress), Long.valueOf(mjVar2.dRJ.total), Boolean.valueOf(mjVar2.dRJ.dgZ));
                if (mjVar2.dRJ.dgZ) {
                    CleanNewUI.this.qri = Util.nowMilliSecond();
                    CleanNewUI.r(CleanNewUI.this);
                    h.INSTANCE.idkeyStat(714, 51, 1, false);
                } else {
                    int i2 = (int) (((((float) mjVar2.dRJ.progress) * 1.0f) / ((float) mjVar2.dRJ.total)) * 100.0f);
                    CleanNewUI cleanNewUI = CleanNewUI.this;
                    if (i2 <= 0) {
                        i2 = 0;
                    }
                    cleanNewUI.fp(i2, 100);
                }
                AppMethodBeat.o(231668);
            }
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CleanNewUI() {
        AppMethodBeat.i(22932);
        AppMethodBeat.o(22932);
    }

    static /* synthetic */ String a(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(22944);
        String bgQ = cleanNewUI.bgQ();
        AppMethodBeat.o(22944);
        return bgQ;
    }

    static /* synthetic */ void a(CleanNewUI cleanNewUI, long j2, long j3, long j4) {
        AppMethodBeat.i(231680);
        cleanNewUI.k(j2, j3, j4);
        AppMethodBeat.o(231680);
    }

    static /* synthetic */ void b(CleanNewUI cleanNewUI, long j2) {
        AppMethodBeat.i(231679);
        cleanNewUI.Cf(j2);
        AppMethodBeat.o(231679);
    }

    static /* synthetic */ boolean d(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(231677);
        boolean cyQ = cleanNewUI.cyQ();
        AppMethodBeat.o(231677);
        return cyQ;
    }

    static /* synthetic */ boolean e(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(231678);
        boolean cyR = cleanNewUI.cyR();
        AppMethodBeat.o(231678);
        return cyR;
    }

    static /* synthetic */ void r(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(231681);
        cleanNewUI.cyV();
        AppMethodBeat.o(231681);
    }

    static {
        AppMethodBeat.i(231682);
        AppMethodBeat.o(231682);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22933);
        super.onCreate(bundle);
        setMMTitle(R.string.b4g);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22921);
                CleanNewUI.this.finish();
                AppMethodBeat.o(22921);
                return false;
            }
        });
        this.qqO = (LinearLayout) $(R.id.ep6);
        this.qqR = (TextView) $(R.id.epp);
        this.qqP = (LinearLayout) $(R.id.i38);
        this.qqO.setVisibility(0);
        this.qqR.setText(getString(R.string.b4a, new Object[]{0}));
        this.qqP.setVisibility(8);
        this.qqS = (LinearLayout) $(R.id.jlu);
        this.qqT = (View) $(R.id.jls);
        this.qqU = (View) $(R.id.g7j);
        this.qqV = (TextView) $(R.id.jlr);
        this.qqY = (TextView) $(R.id.jlw);
        this.qqY.setVisibility(8);
        this.qqW = (TextView) $(R.id.fmz);
        this.qra = (Button) $(R.id.jlm);
        this.qra.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(22922);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (((l) g.af(l.class)).aTq().eiC()) {
                    bp.aVQ();
                }
                Log.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", CleanNewUI.a(CleanNewUI.this));
                CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
                h.INSTANCE.idkeyStat(714, 12, 1, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22922);
            }
        });
        this.qqX = (TextView) $(R.id.ahu);
        this.qrb = (Button) $(R.id.jll);
        this.qrb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(22923);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.CleanNewUI", "clean wechat cache");
                f.a aVar = new f.a(CleanNewUI.this);
                aVar.apb(MMApplicationContext.getContext().getResources().getColor(R.color.cd));
                aVar.bow(CleanNewUI.this.getString(R.string.b49)).Dq(true);
                aVar.c(new f.c() {
                    /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(231660);
                        if (z) {
                            Log.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
                            CleanNewUI cleanNewUI = CleanNewUI.this;
                            CleanNewUI cleanNewUI2 = CleanNewUI.this;
                            CleanNewUI.this.getString(R.string.b48);
                            cleanNewUI.qrg = com.tencent.mm.ui.base.h.b((Context) cleanNewUI2, "", false, (DialogInterface.OnCancelListener) null);
                            CleanNewUI.this.qrl = Util.nowMilliSecond();
                            CleanNewUI.this.qrf = new com.tencent.mm.plugin.f.c.a(d.cyM().pQk, d.cyM().cacheSize, d.cyM().pQl, CleanNewUI.this.qrm);
                            ThreadPool.post(CleanNewUI.this.qrf, "cleanCacheTask");
                            h.INSTANCE.idkeyStat(714, 14, 1, false);
                        }
                        AppMethodBeat.o(231660);
                    }
                }).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22923);
            }
        });
        this.qqQ = (LinearLayout) $(R.id.gn0);
        this.qqZ = (TextView) $(R.id.gmz);
        this.qrc = (Button) $(R.id.gmy);
        this.qrc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(22925);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.CleanNewUI", "qq mgr btn click");
                h.INSTANCE.idkeyStat(714, 3, 1, false);
                if (!CleanNewUI.d(CleanNewUI.this)) {
                    if (CleanNewUI.e(CleanNewUI.this)) {
                        com.tencent.mm.ui.base.h.c(CleanNewUI.this, CleanNewUI.this.getString(R.string.b4t, new Object[]{Util.getSizeMB(CleanNewUI.this.qpP)}), "", CleanNewUI.this.getString(R.string.tm), CleanNewUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass4.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(22924);
                                try {
                                    URL url = new URL(CleanNewUI.this.qpT.getString("url"));
                                    String string = CleanNewUI.this.qpT.getString("md5");
                                    Log.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", url, string);
                                    Intent intent = new Intent();
                                    intent.setClassName(CleanNewUI.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
                                    intent.putExtra("task_name", "腾讯手机管家");
                                    intent.putExtra("title", "腾讯手机管家");
                                    intent.putExtra("task_url", url.toString());
                                    intent.putExtra("file_md5", string);
                                    intent.putExtra("fileType", 1);
                                    intent.putExtra("package_name", "com.tencent.qqpimsecure");
                                    CleanNewUI cleanNewUI = CleanNewUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(cleanNewUI, bl.axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    cleanNewUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(cleanNewUI, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.CleanNewUI", e2, "", new Object[0]);
                                }
                                h.INSTANCE.idkeyStat(714, 4, 1, false);
                                AppMethodBeat.o(22924);
                            }
                        }, null);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", CleanNewUI.qpO);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("showShare", false);
                        c.b(CleanNewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        h.INSTANCE.idkeyStat(714, 5, 1, false);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22925);
            }
        });
        if (WeChatLocaleUtil.isOverseasUserByWechatLanguage() || ChannelUtil.channelId == 1) {
            this.qqQ.setVisibility(8);
            this.qrc.setVisibility(8);
        }
        try {
            HttpWrapperBase.Request request = new HttpWrapperBase.Request(0, null, null, null);
            request.protocal = HttpWrapperBase.PROTOCAL_HTTPS;
            request.host = "jtool.qq.com";
            request.uri = "/channel?productId=31&channelId=102133";
            new HttpURLConnectionWrapper((HttpURLConnection) new URL(request.getUrl()).openConnection()).asyncSend(request, new HttpWrapperBase.Response("") {
                /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.http.HttpWrapperBase.Response
                public final void onComplete() {
                    AppMethodBeat.i(231669);
                    Log.d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        new JSONObject(this.content);
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                        AppMethodBeat.o(231669);
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.CleanNewUI", e2, "", new Object[0]);
                        h.INSTANCE.idkeyStat(714, 6, 1, false);
                        AppMethodBeat.o(231669);
                    }
                }
            }, new MMHandler());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CleanNewUI", e2, e2.getMessage(), new Object[0]);
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
        int i2 = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_reset_calc_index_time", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 0);
        if (i2 > mmkv.getInt("CleanCalcResetIndexTime", 0)) {
            mmkv.encode("CleanCalcAlreadyResetIndex", false);
            mmkv.encode("CleanCalcResetIndexTime", i2);
        }
        boolean z = mmkv.getBoolean("CleanCalcAlreadyResetIndex", false);
        if (!z) {
            Log.i("MicroMsg.CleanNewUI", "reset index.");
            g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, (Object) 0L);
            mmkv.encode("CleanCalcAlreadyResetIndex", true);
            mmkv.encode("CleanCalcMidImg", 0L);
            mmkv.encode("CleanCalcHevcImg", 0L);
        }
        if (!z || !com.tencent.mm.plugin.f.b.crW().csb()) {
            Log.w("MicroMsg.CleanNewUI", "%s it scan not finish, alreadyResetIndex:%b", bgQ(), Boolean.valueOf(z));
            this.qrh = Util.nowMilliSecond();
            this.qrd = true;
            EventCenter.instance.add(this.qro);
            com.tencent.mm.plugin.f.b.crW().kt(true);
            fp(0, 100);
        } else {
            Log.i("MicroMsg.CleanNewUI", "%s it scan finish", bgQ());
            this.qrd = false;
            cyV();
            h.INSTANCE.idkeyStat(714, 50, 1, false);
        }
        h.INSTANCE.idkeyStat(714, 1, 1, false);
        AppMethodBeat.o(22933);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(22934);
        super.onResume();
        if (this.qrk > 0 && d.cyM().qpK != 0) {
            k(d.cyM().qpK, d.cyM().qpu, d.cyM().cacheSize);
        }
        AppMethodBeat.o(22934);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.i(22935);
        super.onDestroy();
        Log.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", bgQ(), Boolean.valueOf(this.qrd));
        if (this.qrd) {
            EventCenter.instance.removeListener(this.qro);
            com.tencent.mm.plugin.f.b crW = com.tencent.mm.plugin.f.b.crW();
            Object[] objArr = new Object[2];
            objArr[0] = crW.bgQ();
            if (crW.pPQ != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", objArr);
            crW.post(new Runnable() {
                /* class com.tencent.mm.plugin.f.b.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(22695);
                    b.this.pPP = false;
                    if (b.this.pPQ != null) {
                        b.this.pPQ.cancel();
                        b.this.pPQ.isStop = true;
                        b.this.pPQ = null;
                        h.INSTANCE.idkeyStat(664, 8, 1, false);
                    }
                    AppMethodBeat.o(22695);
                }
            });
        }
        if (this.qre != null) {
            this.qre.stop();
        }
        AppMethodBeat.o(22935);
    }

    private void Cf(long j2) {
        int i2 = 5;
        AppMethodBeat.i(231670);
        d.cyM();
        long cyN = d.cyN();
        d.cyM();
        long cyO = d.cyO();
        this.qqV.setText(Util.getSizeKB(d.cyM().dataSize + j2));
        int i3 = (int) ((100 * j2) / cyN);
        if (i3 > 0) {
            this.qqY.setText(getString(R.string.b4i, new Object[]{i3 + "%"}));
        } else {
            this.qqY.setText(R.string.b4j);
        }
        int width = getWindowManager().getDefaultDisplay().getWidth() - 48;
        ViewGroup.LayoutParams layoutParams = this.qqT.getLayoutParams();
        layoutParams.width = i3 == 0 ? 5 : (i3 * width) / 100;
        this.qqT.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.qqU.getLayoutParams();
        layoutParams2.width = (int) ((((cyN - cyO) - j2) * ((long) width)) / cyN);
        if (layoutParams2.width != 0) {
            i2 = layoutParams2.width;
        }
        layoutParams2.width = i2;
        this.qqU.setLayoutParams(layoutParams2);
        AppMethodBeat.o(231670);
    }

    private void Cg(long j2) {
        AppMethodBeat.i(231671);
        this.qqW.setText(Util.getSizeKB(j2));
        this.qra.setEnabled(true);
        AppMethodBeat.o(231671);
    }

    private void Ch(long j2) {
        AppMethodBeat.i(231672);
        this.qqX.setText(Util.getSizeKB(j2));
        if (j2 > 0) {
            this.qrb.setEnabled(true);
            AppMethodBeat.o(231672);
            return;
        }
        this.qrb.setEnabled(false);
        AppMethodBeat.o(231672);
    }

    private void cyU() {
        AppMethodBeat.i(231673);
        TextView textView = this.qqZ;
        d.cyM();
        textView.setText(Util.getSizeKB(d.cyO()));
        AppMethodBeat.o(231673);
    }

    private void k(long j2, long j3, long j4) {
        AppMethodBeat.i(231674);
        this.qqO.setVisibility(8);
        this.qqP.setVisibility(0);
        Cf(j2);
        Cg(j3);
        Ch(j4);
        cyU();
        AppMethodBeat.o(231674);
    }

    public final void fp(final int i2, final int i3) {
        AppMethodBeat.i(231675);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(231661);
                CleanNewUI.this.qqR.setText(CleanNewUI.this.getString(R.string.b4a, new Object[]{Integer.valueOf((i2 * 100) / i3)}));
                AppMethodBeat.o(231661);
            }
        });
        AppMethodBeat.o(231675);
    }

    private void cyV() {
        AppMethodBeat.i(231676);
        ((com.tencent.mm.plugin.appbrand.service.f) g.af(com.tencent.mm.plugin.appbrand.service.f.class)).buj();
        ((aj) g.ah(aj.class)).dumpAndMarkFinderFolder();
        com.tencent.mm.cr.d.bpG("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        this.qre = new com.tencent.mm.plugin.clean.b.a(this.qrn);
        this.qrj = Util.nowMilliSecond();
        ThreadPool.post(this.qre, "cleanUI_calc");
        h.INSTANCE.idkeyStat(714, 52, 1, false);
        AppMethodBeat.o(231676);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ul;
    }

    private String bgQ() {
        AppMethodBeat.i(22943);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(22943);
        return sb;
    }

    private boolean cyR() {
        AppMethodBeat.i(22940);
        bg.aVF();
        String str = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_CLEANUI_QQMGRINFO_STRING, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22940);
            return false;
        }
        try {
            this.qpT = new JSONObject(str);
            this.qpQ = this.qpT.getString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.qpT.get("md5");
            this.qpS = this.qpT.getString("launcherID");
            this.qpR = this.qpT.getString("signature");
            this.qpT.get("url");
            this.qpP = this.qpT.getLong("size");
            AppMethodBeat.o(22940);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CleanNewUI", e2, "", new Object[0]);
            AppMethodBeat.o(22940);
            return false;
        }
    }

    private boolean cyQ() {
        String messageDigest;
        AppMethodBeat.i(22941);
        cyR();
        if (!com.tencent.mm.pluginsdk.model.app.q.s(getContext(), this.qpQ)) {
            AppMethodBeat.o(22941);
            return false;
        }
        Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(this, this.qpQ);
        if (cj == null || cj[0] == null || (messageDigest = com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray())) == null || !messageDigest.equalsIgnoreCase(this.qpR)) {
            AppMethodBeat.o(22941);
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.qpQ);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                com.tencent.mm.pluginsdk.model.app.q.k(bundle, this.qpS);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(launchIntentForPackage);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.INSTANCE.idkeyStat(714, 7, 1, false);
                AppMethodBeat.o(22941);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CleanNewUI", e2, "", new Object[0]);
        }
        AppMethodBeat.o(22941);
        return true;
    }
}
