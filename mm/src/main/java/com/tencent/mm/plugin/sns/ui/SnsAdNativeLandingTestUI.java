package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private double DnV = 0.0d;
    private int Dzs;
    private VideoSightView Ezh;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar Ezi;
    private int duration = 0;
    private MMHandler hAk = new MMHandler();
    private int videoHeight;
    private int videoWidth;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsAdNativeLandingTestUI() {
        AppMethodBeat.i(98446);
        AppMethodBeat.o(98446);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98447);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(1024, 1024);
        ((Button) findViewById(R.id.hwa)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(98420);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 259);
                intent.putExtra("select_is_ret", true);
                c.a(SnsAdNativeLandingTestUI.this, ".ui.transmit.SelectConversationUI", intent, 0, new MMActivity.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.MMActivity.a
                    public final void d(int i2, int i3, Intent intent) {
                        final String stringExtra;
                        AppMethodBeat.i(98419);
                        if (i3 == -1) {
                            if (intent == null) {
                                stringExtra = null;
                            } else {
                                stringExtra = intent.getStringExtra("Select_Conv_User");
                            }
                            if (stringExtra == null || stringExtra.length() == 0) {
                                Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                                AppMethodBeat.o(98419);
                                return;
                            }
                            final SnsAdNativeLandingTestUI snsAdNativeLandingTestUI = SnsAdNativeLandingTestUI.this;
                            ab.a.Kgn.a(snsAdNativeLandingTestUI.getController(), "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, snsAdNativeLandingTestUI.getResources().getString(R.string.yq), new y.a() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                                public final void a(boolean z, String str, int i2) {
                                    AppMethodBeat.i(98418);
                                    if (z) {
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.title = "test title";
                                        wXMediaMessage.description = "test desc";
                                        WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                        wXWebpageObject.canvasPageXml = "<xml></xml>";
                                        wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                        wXMediaMessage.mediaObject = wXWebpageObject;
                                        Bitmap bitmap = ap.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
                                        if (bitmap != null && !bitmap.isRecycled()) {
                                            Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        tt ttVar = new tt();
                                        ttVar.eaf.dCE = wXMediaMessage;
                                        ttVar.eaf.toUser = stringExtra;
                                        ttVar.eaf.dMG = 49;
                                        ttVar.eaf.eag = "";
                                        ttVar.eaf.eah = "";
                                        EventCenter.instance.publish(ttVar);
                                        if (!TextUtils.isEmpty(str)) {
                                            tw twVar = new tw();
                                            twVar.eaq.dkV = stringExtra;
                                            twVar.eaq.content = str;
                                            twVar.eaq.type = com.tencent.mm.model.ab.JG(stringExtra);
                                            twVar.eaq.flags = 0;
                                            EventCenter.instance.publish(twVar);
                                        }
                                        h.cD(snsAdNativeLandingTestUI, snsAdNativeLandingTestUI.getString(R.string.z0));
                                        AppMethodBeat.o(98418);
                                        return;
                                    }
                                    AppMethodBeat.o(98418);
                                }
                            });
                        }
                        AppMethodBeat.o(98419);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98420);
            }
        });
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = com.tencent.mm.loader.j.b.aKJ() + "/sns_ad_landingpages";
        View inflate = layoutInflater.inflate(R.layout.buo, (ViewGroup) null);
        inflate.setMinimumHeight(height);
        this.Ezh = new VideoSightView(getContext());
        this.Ezh.setLoop(false);
        ((ViewGroup) inflate.findViewById(R.id.hvt)).addView(this.Ezh, 0, new LinearLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), getContext().getResources().getDimension(R.dimen.ih));
        this.Ezi = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
        this.Ezi.setVisibility(0);
        this.Ezh.setPlayProgressCallback(true);
        ((ViewGroup) inflate).addView(this.Ezi, layoutParams);
        this.Ezi.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(98422);
                Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(i2)));
                SnsAdNativeLandingTestUI.this.DnV = (double) i2;
                SnsAdNativeLandingTestUI.this.Ezh.q((double) i2);
                AppMethodBeat.o(98422);
            }
        });
        this.Ezi.setOnPlayButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(98423);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsAdNativeLandingTestUI.this.Ezh.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
                } else {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98423);
            }
        });
        this.Ezi.setIsPlay(this.Ezh.isPlaying());
        this.Ezi.setVisibility(0);
        this.Ezi.seek(0);
        this.Ezh.setVideoCallback(new j.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void tf() {
                AppMethodBeat.i(98425);
                if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay()) {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
                AppMethodBeat.o(98425);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(98426);
                SnsAdNativeLandingTestUI.this.Ezh.stop();
                AppMethodBeat.o(98426);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onCompletion() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final int fh(final int i2, final int i3) {
                AppMethodBeat.i(98427);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(98424);
                        Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i2 + " video time " + i3);
                        if (i3 > 0) {
                            SnsAdNativeLandingTestUI.this.duration = i3;
                            SnsAdNativeLandingTestUI.this.Dzs = i3;
                        }
                        if (SnsAdNativeLandingTestUI.this.Ezi.getVideoTotalTime() != i3) {
                            SnsAdNativeLandingTestUI.this.Ezi.setVideoTotalTime(i3);
                        }
                        SnsAdNativeLandingTestUI.this.Ezi.seek(i2);
                        AppMethodBeat.o(98424);
                    }
                });
                AppMethodBeat.o(98427);
                return 0;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void eo(int i2, int i3) {
                AppMethodBeat.i(98428);
                SnsAdNativeLandingTestUI.this.videoWidth = i2;
                SnsAdNativeLandingTestUI.this.videoHeight = i3;
                AppMethodBeat.o(98428);
            }
        });
        this.Ezh.setEnableConfigChanged(false);
        this.Ezh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(98429);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!"".equals(SnsAdNativeLandingTestUI.this.Ezh.getVideoPath()) && SnsAdNativeLandingTestUI.this.Ezh.getVideoPath() != null) {
                    if (SnsAdNativeLandingTestUI.this.Ezi.getVisibility() == 0) {
                        SnsAdNativeLandingTestUI.this.Ezi.setVisibility(4);
                    } else {
                        SnsAdNativeLandingTestUI.this.Ezi.setVisibility(0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98429);
            }
        });
        ((ViewGroup) findViewById(R.id.hw_)).addView(inflate, new LinearLayout.LayoutParams(width, height));
        this.Ezh.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(98430);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (SnsAdNativeLandingTestUI.this.getContext() instanceof MMActivity) {
                    ((MMActivity) SnsAdNativeLandingTestUI.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    SnsAdNativeLandingTestUI.this.Ezh.setDrawableWidth(displayMetrics.widthPixels);
                }
                SnsAdNativeLandingTestUI.this.Ezh.requestLayout();
                SnsAdNativeLandingTestUI.this.Ezh.postInvalidate();
                AppMethodBeat.o(98430);
            }
        });
        new a(str, "adId" + "_image_" + MD5Util.getMD5String("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"), aj.dRd(), new a.AbstractC1730a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void dx(String str, int i2) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void aas(String str) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void Hn(String str) {
                AppMethodBeat.i(98431);
                SnsAdNativeLandingTestUI.this.Ezh.setThumb(BitmapUtil.decodeFile(str));
                AppMethodBeat.o(98431);
            }
        }).execute("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        new a(str, "adId" + "_stream_" + MD5Util.getMD5String("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"), aj.dRd(), new a.AbstractC1730a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void dx(String str, int i2) {
                AppMethodBeat.i(98432);
                if (SnsAdNativeLandingTestUI.this.Ezh.isPlaying()) {
                    AppMethodBeat.o(98432);
                    return;
                }
                SnsAdNativeLandingTestUI.this.Ezh.setLoop(false);
                if (!str.equals(SnsAdNativeLandingTestUI.this.Ezh.getVideoPath())) {
                    SnsAdNativeLandingTestUI.this.Ezh.setVideoPath(str);
                }
                if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay()) {
                    SnsAdNativeLandingTestUI.this.Ezh.q(SnsAdNativeLandingTestUI.this.DnV);
                    SnsAdNativeLandingTestUI.this.Ezh.start();
                }
                AppMethodBeat.o(98432);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void aas(String str) {
                AppMethodBeat.i(98433);
                Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
                AppMethodBeat.o(98433);
            }

            @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
            public final void Hn(String str) {
                AppMethodBeat.i(98434);
                SnsAdNativeLandingTestUI.this.Ezh.setVideoPath(str);
                SnsAdNativeLandingTestUI.this.Ezh.setLoop(true);
                if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay()) {
                    SnsAdNativeLandingTestUI.this.Ezh.q(SnsAdNativeLandingTestUI.this.DnV);
                    SnsAdNativeLandingTestUI.this.Ezh.start();
                }
                AppMethodBeat.o(98434);
            }
        }, Downloads.SPLIT_RANGE_SIZE_WAP).execute("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        AppMethodBeat.o(98447);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.buv;
    }

    static class a extends AsyncTask<String, Void, Void> {
        private static Set<String> Ezn = new HashSet();
        private static byte[] Ezo = new byte[0];
        final String EkP;
        final String EkQ;
        final int EkS;
        final String EkT;
        final AbstractC1730a Ezp;
        final String fileName;
        final String filePath;
        final MMHandler handler;

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$a$a  reason: collision with other inner class name */
        public interface AbstractC1730a {
            void Hn(String str);

            void aas(String str);

            void dx(String str, int i2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(String[] strArr) {
            AppMethodBeat.i(98444);
            Void O = O(strArr);
            AppMethodBeat.o(98444);
            return O;
        }

        static {
            AppMethodBeat.i(98445);
            AppMethodBeat.o(98445);
        }

        public a(String str, String str2, MMHandler mMHandler, AbstractC1730a aVar) {
            this(str, str2, mMHandler, aVar, 0);
        }

        public a(String str, String str2, final MMHandler mMHandler, final AbstractC1730a aVar, int i2) {
            AppMethodBeat.i(98442);
            s.boN(str);
            this.EkT = str;
            this.fileName = str2;
            this.filePath = str + FilePathGenerator.ANDROID_DIR_SEP + str2;
            this.EkQ = "temp_".concat(String.valueOf(str2));
            this.EkP = str + FilePathGenerator.ANDROID_DIR_SEP + this.EkQ;
            this.handler = mMHandler;
            this.EkS = i2;
            this.Ezp = new AbstractC1730a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
                public final void dx(final String str, final int i2) {
                    AppMethodBeat.i(98439);
                    mMHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(98436);
                            aVar.dx(str, i2);
                            AppMethodBeat.o(98436);
                        }
                    });
                    AppMethodBeat.o(98439);
                }

                @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
                public final void aas(final String str) {
                    AppMethodBeat.i(98440);
                    mMHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(98437);
                            aVar.aas(str);
                            AppMethodBeat.o(98437);
                        }
                    });
                    AppMethodBeat.o(98440);
                }

                @Override // com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AbstractC1730a
                public final void Hn(final String str) {
                    AppMethodBeat.i(98441);
                    mMHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.AnonymousClass1.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(98438);
                            aVar.Hn(str);
                            AppMethodBeat.o(98438);
                        }
                    });
                    AppMethodBeat.o(98441);
                }
            };
            AppMethodBeat.o(98442);
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x016e A[SYNTHETIC, Splitter:B:102:0x016e] */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x0195 A[SYNTHETIC, Splitter:B:115:0x0195] */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x019a A[Catch:{ IOException -> 0x01cb }] */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x019f A[SYNTHETIC, Splitter:B:120:0x019f] */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01ac A[SYNTHETIC, Splitter:B:125:0x01ac] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0157 A[SYNTHETIC, Splitter:B:92:0x0157] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x015c A[Catch:{ IOException -> 0x01dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0161 A[SYNTHETIC, Splitter:B:97:0x0161] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Void O(java.lang.String... r11) {
            /*
            // Method dump skipped, instructions count: 499
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.O(java.lang.String[]):java.lang.Void");
        }
    }

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.i(98448);
        snsAdNativeLandingTestUI.DnV = snsAdNativeLandingTestUI.Ezh.getLastProgresstime();
        snsAdNativeLandingTestUI.Ezh.pause();
        snsAdNativeLandingTestUI.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(98421);
                SnsAdNativeLandingTestUI.this.Ezi.setIsPlay(false);
                AppMethodBeat.o(98421);
            }
        });
        AppMethodBeat.o(98448);
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.i(98449);
        snsAdNativeLandingTestUI.Ezh.q(snsAdNativeLandingTestUI.DnV);
        snsAdNativeLandingTestUI.Ezh.start();
        snsAdNativeLandingTestUI.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(98435);
                SnsAdNativeLandingTestUI.this.Ezi.setIsPlay(true);
                AppMethodBeat.o(98435);
            }
        });
        AppMethodBeat.o(98449);
    }
}
