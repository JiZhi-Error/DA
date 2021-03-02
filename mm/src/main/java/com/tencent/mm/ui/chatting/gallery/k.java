package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class k {
    int Dzs = 0;
    public b.EnumC2096b PAD;
    public HashMap<String, Boolean> PAE = new HashMap<>();
    public RelativeLayout PAF;
    public j PAG;
    public ImageView PAH;
    public ImageView PAI;
    public MMPinProgressBtn PAJ;
    public View PAK;
    public RelativeLayout PAL;
    public ImageView PAM;
    public ImageView PAN;
    public j PAO;
    public MMPinProgressBtn PAP;
    public TextView PAQ;
    public RelativeLayout PAR;
    public TextView PAS;
    public LinearLayout PAT;
    public TextView PAU;
    public TextView PAV;
    public ImageView PAW;
    public ProgressBar PAX;
    public ProgressBar PAY;
    public LinearLayout PAZ;
    public TextView PBa;
    public ImageView PBb;
    public MultiTouchImageView PBc;
    public WxImageView PBd;
    public boolean PBe;
    int PBf = 0;
    int PBg = 0;
    public b PwU;
    public View convertView;
    long createTime;
    String dRL = "";
    String fileId;
    public int mPosition;
    public TextView thO;

    @TargetApi(11)
    public k(b bVar, View view) {
        AppMethodBeat.i(36331);
        this.convertView = view;
        this.PwU = bVar;
        this.PBc = (MultiTouchImageView) view.findViewById(R.id.dup);
        this.PBd = (WxImageView) view.findViewById(R.id.jrc);
        this.PAY = (ProgressBar) view.findViewById(R.id.dvn);
        if (this.PBd != null) {
            this.PBd.setForceTileFlag(c.Tile);
        }
        AppMethodBeat.o(36331);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] PwJ = new int[b.EnumC2096b.values().length];

        static {
            AppMethodBeat.i(36330);
            try {
                PwJ[b.EnumC2096b.image.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                PwJ[b.EnumC2096b.video.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                PwJ[b.EnumC2096b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                PwJ[b.EnumC2096b.unkown.ordinal()] = 4;
                AppMethodBeat.o(36330);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(36330);
            }
        }
    }

    public static void ai(View view, int i2) {
        AppMethodBeat.i(36332);
        if (view != null) {
            view.setVisibility(i2);
        }
        AppMethodBeat.o(36332);
    }

    public final k gTb() {
        AppMethodBeat.i(36333);
        if (this.PAT == null) {
            this.PAT = (LinearLayout) ((ViewStub) this.convertView.findViewById(R.id.dvq)).inflate();
            this.PAX = (ProgressBar) this.PAT.findViewById(R.id.buu);
            this.PAU = (TextView) this.PAT.findViewById(R.id.buv);
            this.PAV = (TextView) this.PAT.findViewById(R.id.but);
            this.PAW = (ImageView) this.PAT.findViewById(R.id.buw);
        }
        AppMethodBeat.o(36333);
        return this;
    }

    public final k gTc() {
        AppMethodBeat.i(36334);
        if (this.PAZ == null) {
            this.PAZ = (LinearLayout) ((ViewStub) this.convertView.findViewById(R.id.dvo)).inflate();
            this.PBb = (ImageView) this.PAZ.findViewById(R.id.bty);
            this.PBa = (TextView) this.PAZ.findViewById(R.id.btz);
        }
        AppMethodBeat.o(36334);
        return this;
    }

    public final k gTd() {
        AppMethodBeat.i(36335);
        if (this.PAF == null) {
            this.PAF = (RelativeLayout) ((ViewStub) this.convertView.findViewById(R.id.hrx)).inflate();
            this.PAG = v.iE(this.convertView.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.PAF.addView((View) this.PAG, layoutParams);
            ((View) this.PAG).setVisibility(8);
            this.PAK = this.PAF.findViewById(R.id.ipe);
            this.PAK.setVisibility(8);
            this.thO = (TextView) this.PAF.findViewById(R.id.hqu);
            this.PAJ = (MMPinProgressBtn) this.PAF.findViewById(R.id.hrm);
            this.PAJ.setVisibility(8);
            this.PAH = (ImageView) this.PAF.findViewById(R.id.hrt);
            this.PAI = (ImageView) this.PAF.findViewById(R.id.j72);
            this.PAG.setVideoCallback(new j.a() {
                /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void tf() {
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onError(int i2, int i3) {
                    AppMethodBeat.i(36319);
                    k.this.PAG.stop();
                    final String str = (String) ((View) k.this.PAG).getTag();
                    CrashReportFactory.reportRawMessage(Base64.encodeToString((e.eVv() + "[ImageGallery] on play sight error, what=" + i2 + ", extra=" + i3 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(36317);
                            if (Util.isNullOrNil(str)) {
                                h.n(k.this.PwU.Pwv, R.string.hwr, R.string.b1n);
                                AppMethodBeat.o(36317);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            FileProviderHelper.setIntentDataAndType((Context) k.this.PwU.Pwv, intent, new o(str), "video/*", false);
                            try {
                                ImageGalleryUI imageGalleryUI = k.this.PwU.Pwv;
                                a bl = new a().bl(Intent.createChooser(intent, k.this.PwU.Pwv.getContext().getString(R.string.cd1)));
                                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                imageGalleryUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(36317);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                                h.n(k.this.PwU.Pwv, R.string.caa, R.string.cab);
                                AppMethodBeat.o(36317);
                            }
                        }
                    });
                    k.this.PAE.put(str, Boolean.TRUE);
                    AppMethodBeat.o(36319);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onCompletion() {
                    AppMethodBeat.i(36320);
                    k.this.PAG.start();
                    k.this.PAK.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(36318);
                            if (k.this.PAK == null || k.this.PAK.getVisibility() == 0) {
                                AppMethodBeat.o(36318);
                                return;
                            }
                            if (k.this.PAK.getTag() != null && (k.this.PAK.getTag() instanceof s)) {
                                s sVar = (s) k.this.PAK.getTag();
                                if (sVar.jsw != null && !Util.isNullOrNil(sVar.jsw.iyZ)) {
                                    k.this.PAK.setVisibility(8);
                                    AppMethodBeat.o(36318);
                                    return;
                                } else if (sVar.jsw != null && !Util.isNullOrNil(sVar.jsw.izc) && !Util.isNullOrNil(sVar.jsw.izd)) {
                                    k.this.PAK.setVisibility(8);
                                    AppMethodBeat.o(36318);
                                    return;
                                }
                            }
                            k.this.PAK.setVisibility(0);
                            k.this.PAK.startAnimation(AnimationUtils.loadAnimation(k.this.PAK.getContext(), R.anim.br));
                            AppMethodBeat.o(36318);
                        }
                    });
                    AppMethodBeat.o(36320);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final int fh(int i2, int i3) {
                    return 0;
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void eo(int i2, int i3) {
                }
            });
            this.thO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass2 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(36322);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view.getTag() != null && (view.getTag() instanceof ca)) {
                        ca caVar = (ca) view.getTag();
                        com.tencent.mm.ui.chatting.a.a(a.EnumC2087a.EnterCompleteVideo, caVar);
                        s QN = u.QN(caVar.field_imgPath);
                        eeq eeq = QN.jsw;
                        if (eeq != null && !af.isNullOrNil(eeq.iyZ)) {
                            com.tencent.mm.modelvideo.o.bhj();
                            String Qx = t.Qx(caVar.field_imgPath);
                            Intent intent = new Intent();
                            intent.putExtra("KFromTimeLine", false);
                            intent.putExtra("KStremVideoUrl", eeq.iyZ);
                            intent.putExtra("KThumUrl", eeq.ize);
                            intent.putExtra("KThumbPath", Qx);
                            intent.putExtra("KMediaId", "fakeid_" + caVar.field_msgId);
                            intent.putExtra("KMediaVideoTime", eeq.LxJ);
                            intent.putExtra("KMediaTitle", eeq.izb);
                            intent.putExtra("StreamWording", eeq.izc);
                            intent.putExtra("StremWebUrl", eeq.izd);
                            String str = caVar.field_talker;
                            boolean Eq = ab.Eq(str);
                            String Ks = Eq ? bp.Ks(caVar.field_content) : str;
                            intent.putExtra("KSta_StremVideoAduxInfo", eeq.izf);
                            intent.putExtra("KSta_StremVideoPublishId", eeq.izg);
                            intent.putExtra("KSta_SourceType", 1);
                            if (Eq) {
                                i2 = a.b.TalkChat.value;
                            } else {
                                i2 = a.b.Chat.value;
                            }
                            intent.putExtra("KSta_Scene", i2);
                            intent.putExtra("KSta_FromUserName", Ks);
                            intent.putExtra("KSta_ChatName", str);
                            intent.putExtra("KSta_MsgId", caVar.field_msgSvrId);
                            intent.putExtra("KSta_SnsStatExtStr", QN.ean);
                            if (Eq) {
                                intent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.v.Ie(str));
                            }
                            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                                com.tencent.mm.br.c.b(k.this.PwU.Pwv.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", intent);
                                Log.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
                            } else {
                                com.tencent.mm.br.c.b(k.this.PwU.Pwv.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
                            }
                        } else if (eeq != null && !Util.isNullOrNil(eeq.izc) && !Util.isNullOrNil(eeq.izd)) {
                            Log.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + eeq.izd);
                            final Intent intent2 = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", QN.ean);
                            intent2.putExtra("jsapiargs", bundle);
                            intent2.putExtra("rawUrl", eeq.izd);
                            intent2.putExtra("useJs", true);
                            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(36321);
                                    com.tencent.mm.br.c.b(k.this.PwU.Pwv.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.o(36321);
                                }
                            });
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(36322);
                }
            });
        }
        AppMethodBeat.o(36335);
        return this;
    }

    public final k gTe() {
        AppMethodBeat.i(36336);
        if (this.PAL == null) {
            if (this.PBd != null) {
                this.PBd.setVisibility(8);
            }
            if (this.PBc != null) {
                this.PBc.setVisibility(8);
            }
            this.PAL = (RelativeLayout) ((ViewStub) this.convertView.findViewById(R.id.j6e)).inflate();
            this.PAM = (ImageView) this.PAL.findViewById(R.id.j54);
            this.PAN = (ImageView) this.PAL.findViewById(R.id.j71);
            this.PAN.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(36323);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (k.this.PwU != null) {
                        Log.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition));
                        k.this.PwU.amS(k.this.mPosition);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(36323);
                }
            });
            com.tencent.mm.modelcontrol.e.baZ();
            if (com.tencent.mm.modelcontrol.e.bbm()) {
                this.PAO = new VideoPlayerTextureView(this.convertView.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 150, 1, false);
            } else {
                this.PAO = new VideoTextureView(this.convertView.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 151, 1, false);
            }
            this.PAQ = (TextView) this.convertView.findViewById(R.id.bl3);
            this.PAO.setPlayProgressCallback(true);
            this.PAL.addView((View) this.PAO, 1, new RelativeLayout.LayoutParams(-1, -1));
            this.PAP = (MMPinProgressBtn) this.PAL.findViewById(R.id.j4k);
            this.PAP.setVisibility(8);
            ((View) this.PAO).setVisibility(8);
            this.PAR = (RelativeLayout) this.convertView.findViewById(R.id.j4u);
            this.PAS = (TextView) this.convertView.findViewById(R.id.j4v);
            this.PAO.setVideoCallback(new j.a() {
                /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void tf() {
                    AppMethodBeat.i(36326);
                    if (k.this.PwU != null) {
                        k.this.PwU.PwB.gSW();
                    }
                    AppMethodBeat.o(36326);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onError(int i2, int i3) {
                    AppMethodBeat.i(36327);
                    Log.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i2 + " extra: " + i3);
                    if (k.this.PwU != null) {
                        k.this.PwU.PwB.lh(i2, i3);
                    }
                    k.this.PwU.Pwv.PyB.jpW = 4;
                    k.this.PwU.Pwv.PyB.pLD = "what : " + i2 + " extra: " + i3;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12084, Integer.valueOf(k.this.PBf), Integer.valueOf(k.this.Dzs * 1000), 0, 4, k.this.dRL, Integer.valueOf(k.this.PBg), k.this.fileId, Long.valueOf(k.this.createTime));
                    AppMethodBeat.o(36327);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onCompletion() {
                    AppMethodBeat.i(36328);
                    k.this.PwU.Pwv.PyB.i(k.this.PwU.gSg(), 7);
                    k.this.PwU.Pwv.PyB.jpW = 4;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(36324);
                            k.this.PwU.Pwv.setVideoStateIv(true);
                            b bVar = k.this.PwU;
                            bVar.PwB.ank(k.this.mPosition);
                            k.this.PwU.PwB.gSX();
                            AppMethodBeat.o(36324);
                        }
                    });
                    AppMethodBeat.o(36328);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final int fh(final int i2, final int i3) {
                    AppMethodBeat.i(36329);
                    Log.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i2), Integer.valueOf(k.this.Dzs), Integer.valueOf(i3), Integer.valueOf(k.this.PBf), Integer.valueOf(k.this.PBg), k.this.dRL);
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.k.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(36325);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(k.this.PBf);
                            objArr[1] = Integer.valueOf(i3 <= 0 ? k.this.Dzs * 1000 : i3);
                            objArr[2] = Integer.valueOf(i2);
                            objArr[3] = 1;
                            objArr[4] = k.this.dRL;
                            objArr[5] = Integer.valueOf(k.this.PBg);
                            objArr[6] = k.this.fileId;
                            objArr[7] = Long.valueOf(k.this.createTime);
                            hVar.a(12084, objArr);
                            AppMethodBeat.o(36325);
                        }
                    });
                    AppMethodBeat.o(36329);
                    return 0;
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void eo(int i2, int i3) {
                }
            });
        }
        AppMethodBeat.o(36336);
        return this;
    }

    public final void a(int i2, int i3, int i4, String str, String str2, long j2) {
        this.Dzs = i2;
        this.PBf = i3;
        this.PBg = i4;
        this.dRL = str;
        this.fileId = str2;
        this.createTime = j2;
    }

    public final void d(boolean z, float f2) {
        AppMethodBeat.i(36337);
        Log.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f2));
        if (z) {
            View view = (View) gTe().PAO;
            view.setAlpha(f2);
            ai(view, 0);
            if (((double) f2) >= 1.0d) {
                ai(gTe().PAM, 8);
                ai(gTe().PAN, 8);
            }
            AppMethodBeat.o(36337);
            return;
        }
        ai((View) gTe().PAO, 8);
        ai(gTe().PAM, 0);
        ai(gTe().PAN, 0);
        AppMethodBeat.o(36337);
    }
}
