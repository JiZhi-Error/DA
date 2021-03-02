package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vending.g.d;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s {
    int DDM;
    public g ISU;
    int IUQ;
    com.tencent.mm.ui.widget.a.e lBM;
    String mHk;
    h mHo;
    WebView.b mHp;
    WebView.b mHq;
    ScanCodeSheetItemLogic mHu;
    private h.c mHw = new h.c() {
        /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.modeltools.h.c
        public final void abF(String str) {
            AppMethodBeat.i(78435);
            s sVar = s.this;
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("img_path", str);
            bundle.putInt("x_down", sVar.ISU.ppd);
            bundle.putInt("y_down", sVar.ISU.ppe);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, d.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(78442);
                    Bundle bundle2 = bundle;
                    String string = bundle2.getString("result");
                    int i2 = bundle2.getInt("code_type");
                    int i3 = bundle2.getInt("code_version");
                    s sVar = s.this;
                    Log.i("MicroMsg.LuggageWebViewLongClickHelper", "onGetQRCodeResult");
                    if (!sVar.gcd()) {
                        sVar.mHk = string;
                        sVar.IUQ = i2;
                        sVar.DDM = i3;
                        sVar.gce();
                        if (Util.isNullOrNil(sVar.mHk)) {
                            Log.w("MicroMsg.LuggageWebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
                            AppMethodBeat.o(78442);
                            return;
                        } else if (g.ci(sVar.IUQ, sVar.mHk)) {
                            Log.i("MicroMsg.LuggageWebViewLongClickHelper", "processGetWXACodeNickName");
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("wxa_result", sVar.mHk);
                            bundle3.putInt("wxa_code_type", sVar.IUQ);
                            bundle3.putInt("wxa_code_version", sVar.DDM);
                            bundle3.putInt("type", 4);
                            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle3, d.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass9 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.mm.ipcinvoker.d
                                public final /* synthetic */ void bn(Bundle bundle) {
                                    AppMethodBeat.i(78445);
                                    Bundle bundle2 = bundle;
                                    s sVar = s.this;
                                    Log.i("MicroMsg.LuggageWebViewLongClickHelper", "onFetchQrCodeResp");
                                    sVar.mHu.q(bundle2.getInt("key_resp_ret", -1), bundle2.getByteArray("key_resp_item_bytes"));
                                    AppMethodBeat.o(78445);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(78442);
                }
            });
            AppMethodBeat.o(78435);
        }
    };
    a.b xxK = new a.b() {
        /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass7 */

        @Override // com.tencent.mm.ui.widget.snackbar.a.b
        public final void bDZ() {
            AppMethodBeat.i(78443);
            FavUrlTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.a(favUrlTask);
            AppMethodBeat.o(78443);
        }
    };

    public s(g gVar) {
        AppMethodBeat.i(78461);
        this.ISU = gVar;
        this.ISU.ITd.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass11 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(78447);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                Log.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
                s sVar = s.this;
                sVar.mHk = null;
                sVar.mHq = null;
                sVar.mHp = null;
                sVar.mHu.onDismiss();
                if (s.this.gcd()) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(78447);
                    return false;
                }
                boolean gd = s.this.gd(view);
                com.tencent.mm.hellhoundlib.a.a.a(gd, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(78447);
                return gd;
            }
        });
        this.mHu = new ScanCodeSheetItemLogic(gVar.mContext, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(78444);
                if (s.this.lBM != null && s.this.lBM.isShowing()) {
                    s.this.gce();
                }
                AppMethodBeat.o(78444);
            }
        });
        AppMethodBeat.o(78461);
    }

    /* access modifiers changed from: package-private */
    public final boolean gcd() {
        return this.ISU == null;
    }

    /* access modifiers changed from: package-private */
    public final void gce() {
        AppMethodBeat.i(78462);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(78446);
                if (s.this.mHp != null) {
                    s.this.b(s.this.mHp);
                    AppMethodBeat.o(78446);
                    return;
                }
                if (s.this.mHq != null) {
                    s.this.a(s.this.mHq);
                }
                AppMethodBeat.o(78446);
            }
        });
        AppMethodBeat.o(78462);
    }

    /* access modifiers changed from: package-private */
    public final boolean gd(View view) {
        AppMethodBeat.i(78463);
        try {
            if (view instanceof android.webkit.WebView) {
                WebView.b hitTestResult = this.ISU.ITd.getHitTestResult();
                if (hitTestResult == null) {
                    AppMethodBeat.o(78463);
                    return false;
                }
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(hitTestResult);
                }
                AppMethodBeat.o(78463);
                return false;
            }
            if (view instanceof MMWebView) {
                WebView.b hitTestResult2 = ((MMWebView) view).getHitTestResult();
                if (hitTestResult2 == null) {
                    AppMethodBeat.o(78463);
                    return false;
                } else if (hitTestResult2.mType == 5 || hitTestResult2.mType == 8) {
                    a(hitTestResult2);
                }
            }
            AppMethodBeat.o(78463);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.LuggageWebViewLongClickHelper", "onCreateContextMenu exp %s", e2.getMessage());
        }
    }

    private boolean aYx(final String str) {
        AppMethodBeat.i(78466);
        if (this.lBM == null) {
            this.lBM = new com.tencent.mm.ui.widget.a.e(this.ISU.mContext, 1, false);
        }
        this.lBM.HLX = new o.f() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                boolean z;
                AppMethodBeat.i(78448);
                s sVar = s.this;
                if (MMApplicationContext.isMMProcess()) {
                    z = com.tencent.mm.kernel.g.aAc();
                } else {
                    Bundle bundle = (Bundle) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, null, b.c.class);
                    z = bundle != null ? bundle.getBoolean("has_set_uin", false) : true;
                }
                boolean gtH = sVar.ISU.gbF().aZF(sVar.ISU.getUrl()).gtH();
                boolean gtI = sVar.ISU.gbF().aZF(sVar.ISU.getUrl()).gtI();
                Log.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(z), Boolean.valueOf(gtH), Boolean.valueOf(gtI));
                ArrayList arrayList = new ArrayList();
                if (z && gtH) {
                    arrayList.add(new c(1, sVar.ISU.mContext.getString(R.string.ftk)));
                }
                arrayList.add(new c(2, sVar.ISU.mContext.getString(R.string.gau)));
                if (z && gtI) {
                    arrayList.add(new c(3, sVar.ISU.mContext.getString(R.string.fn9)));
                }
                if (sVar.mHk != null) {
                    arrayList.add(new c(4, sVar.mHu.Wp(sVar.IUQ)));
                }
                sVar.lBM.setFooterView(null);
                mVar.clear();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c cVar = (c) arrayList.get(i2);
                    if (cVar.id == 4) {
                        sVar.lBM.setFooterView(sVar.mHu.a(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass3 */

                            /* JADX WARNING: Removed duplicated region for block: B:14:0x00be  */
                            /* JADX WARNING: Removed duplicated region for block: B:19:0x010e  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void onClick(android.view.View r10) {
                                /*
                                // Method dump skipped, instructions count: 281
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.s.AnonymousClass3.onClick(android.view.View):void");
                            }
                        }, sVar.IUQ, sVar.mHk, 7));
                    } else {
                        mVar.d(cVar.id, cVar.title);
                    }
                }
                AppMethodBeat.o(78448);
            }
        };
        this.lBM.HLY = new o.g() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass13 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(78449);
                switch (menuItem.getItemId()) {
                    case 1:
                        s sVar = s.this;
                        String str = str;
                        z.a(sVar.ISU.mContext, str, com.tencent.xweb.c.hsp().getCookie(str), com.tencent.mm.compatible.util.e.apn(), new z.a() {
                            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass4 */

                            @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                            public final void abE(String str) {
                                AppMethodBeat.i(78438);
                                Bundle bundle = new Bundle();
                                bundle.putString("img_path", str);
                                Context context = s.this.ISU.mContext;
                                Intent intent = new Intent();
                                intent.putExtra("task_class_name", e.class.getName());
                                intent.putExtra("input_data", bundle);
                                intent.putExtra("orientation", -1);
                                com.tencent.mm.br.c.b(context, "webview", ".luggage.ipc.IpcProxyUI", intent);
                                AppMethodBeat.o(78438);
                            }
                        });
                        AppMethodBeat.o(78449);
                        return;
                    case 2:
                        s sVar2 = s.this;
                        String str2 = str;
                        z.b(sVar2.ISU.mContext, str2, com.tencent.xweb.c.hsp().getCookie(str2), com.tencent.mm.compatible.util.e.apn());
                        AppMethodBeat.o(78449);
                        return;
                    case 3:
                        s sVar3 = s.this;
                        String str3 = str;
                        z.a(sVar3.ISU.mContext, str3, com.tencent.xweb.c.hsp().getCookie(str3), com.tencent.mm.compatible.util.e.apn(), new z.a() {
                            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass5 */

                            @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                            public final void abE(String str) {
                                AppMethodBeat.i(78441);
                                Bundle bundle = new Bundle();
                                bundle.putString("image_path", str);
                                com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, a.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                    /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass5.AnonymousClass1 */

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.ipcinvoker.d
                                    public final /* synthetic */ void bn(Bundle bundle) {
                                        AppMethodBeat.i(78440);
                                        final Bundle bundle2 = bundle;
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(78439);
                                                com.tencent.mm.plugin.fav.ui.e.a(bundle2.getInt("fav_simple_img_result"), (Activity) s.this.ISU.mContext, s.this.xxK);
                                                AppMethodBeat.o(78439);
                                            }
                                        });
                                        AppMethodBeat.o(78440);
                                    }
                                });
                                AppMethodBeat.o(78441);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(78449);
            }
        };
        this.lBM.PGl = new e.b() {
            /* class com.tencent.mm.plugin.webview.luggage.s.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(78436);
                if (s.this.mHo != null) {
                    try {
                        s.this.IUQ = 0;
                        s.this.mHk = null;
                        s.this.mHu.onDismiss();
                        String str = s.this.mHo.Jbk;
                        Bundle bundle = new Bundle();
                        bundle.putInt("type", 2);
                        bundle.putString("img_path", str);
                        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, d.class, null);
                        s.this.mHo.gdA();
                        AppMethodBeat.o(78436);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LuggageWebViewLongClickHelper", "cancel capture failed");
                    }
                }
                AppMethodBeat.o(78436);
            }
        };
        if (!((Activity) this.ISU.mContext).isFinishing()) {
            this.lBM.dGm();
        }
        boolean isShowing = this.lBM.isShowing();
        AppMethodBeat.o(78466);
        return isShowing;
    }

    private boolean gcf() {
        AppMethodBeat.i(78467);
        if (!this.ISU.gbF().aZF(this.ISU.getUrl()).gtD()) {
            AppMethodBeat.o(78467);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, null, b.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(78467);
            return false;
        }
        AppMethodBeat.o(78467);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class b implements k<IPCBoolean, IPCBoolean> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCBoolean iPCBoolean) {
            AppMethodBeat.i(78452);
            IPCBoolean gcg = gcg();
            AppMethodBeat.o(78452);
            return gcg;
        }

        private static IPCBoolean gcg() {
            int i2;
            boolean z = true;
            AppMethodBeat.i(78451);
            IPCBoolean iPCBoolean = new IPCBoolean();
            try {
                i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("EnableWebviewScanQRCode"), 1);
            } catch (Exception e2) {
                Log.e("MicroMsg.LuggageWebViewLongClickHelper", "isAllowScanQRCode parseInt failed");
                i2 = 0;
            }
            if (i2 != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.o(78451);
            return iPCBoolean;
        }
    }

    static class e implements com.tencent.mm.plugin.webview.luggage.ipc.c {
        private e() {
        }

        @Override // com.tencent.mm.plugin.webview.luggage.ipc.c
        public final void a(Context context, Bundle bundle, final com.tencent.mm.plugin.webview.luggage.ipc.a aVar) {
            EmojiInfo emojiInfo;
            boolean z;
            AppMethodBeat.i(78460);
            String string = bundle.getString("img_path");
            if (ImgUtil.isGif(string)) {
                EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(com.tencent.mm.b.g.getMD5(string));
                if (aml == null || !aml.hYi()) {
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                    MMApplicationContext.getContext();
                    emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(emojiMgr.amn(string));
                } else {
                    emojiInfo = aml;
                }
                long boW = emojiInfo == null ? 0 : com.tencent.mm.vfs.s.boW(emojiInfo.hYx());
                String hYx = emojiInfo == null ? string : emojiInfo.hYx();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if ((BitmapUtil.decodeFile(hYx, options) == null || options.outHeight <= com.tencent.mm.n.c.aqo()) && options.outWidth <= com.tencent.mm.n.c.aqo()) {
                    z = false;
                } else {
                    z = true;
                }
                if (boW > ((long) com.tencent.mm.n.c.aqp()) || z) {
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.bs3), "", context.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.bs3), "", context.getString(R.string.e2u), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.luggage.s.e.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(78458);
                            aVar.v(null);
                            AppMethodBeat.o(78458);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.luggage.s.e.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(78459);
                            aVar.v(null);
                            AppMethodBeat.o(78459);
                        }
                    });
                    AppMethodBeat.o(78460);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", emojiInfo != null ? emojiInfo.getMd5() : "");
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                com.tencent.mm.plugin.webview.a.a.jRt.k(intent, context);
                aVar.v(null);
                AppMethodBeat.o(78460);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", string);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.jRt.k(intent2, context);
            aVar.v(null);
            AppMethodBeat.o(78460);
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(78450);
            Bundle bundle2 = bundle;
            cz czVar = new cz();
            ((ad) com.tencent.mm.kernel.g.af(ad.class)).a(czVar, 1, bundle2.getString("image_path", ""));
            EventCenter.instance.publish(czVar);
            bundle2.putInt("fav_simple_img_result", czVar.dGa.ret);
            dVar.bn(bundle2);
            AppMethodBeat.o(78450);
        }
    }

    static class d implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private Map<String, Integer> IUV;
        private IListener IUW = new IListener<qy>() {
            /* class com.tencent.mm.plugin.webview.luggage.s.d.AnonymousClass2 */

            {
                AppMethodBeat.i(160420);
                this.__eventId = qy.class.getName().hashCode();
                AppMethodBeat.o(160420);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(qy qyVar) {
                AppMethodBeat.i(78454);
                qy qyVar2 = qyVar;
                if (d.this.IUV == null || d.this.IUV.containsKey(qyVar2.dXy.filePath)) {
                    if (d.this.IUV != null) {
                        d.this.IUV.remove(qyVar2.dXy.filePath);
                    }
                    Log.w("MicroMsg.QBarLogicTask", "delete qb recog fail: %s", qyVar2.dXy.filePath);
                    com.tencent.mm.vfs.s.deleteFile(qyVar2.dXy.filePath);
                    AppMethodBeat.o(78454);
                } else {
                    AppMethodBeat.o(78454);
                }
                return false;
            }
        };
        private IListener hms = new IListener<qz>() {
            /* class com.tencent.mm.plugin.webview.luggage.s.d.AnonymousClass1 */

            {
                AppMethodBeat.i(160419);
                this.__eventId = qz.class.getName().hashCode();
                AppMethodBeat.o(160419);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(qz qzVar) {
                AppMethodBeat.i(78453);
                qz qzVar2 = qzVar;
                if (!(qzVar2 instanceof qz)) {
                    AppMethodBeat.o(78453);
                } else if (d.this.IUV == null || d.this.IUV.containsKey(qzVar2.dXz.filePath)) {
                    if (d.this.IUV != null) {
                        d.this.IUV.remove(qzVar2.dXz.filePath);
                    }
                    com.tencent.mm.vfs.s.deleteFile(qzVar2.dXz.filePath);
                    Log.d("MicroMsg.QBarLogicTask", "result: " + qzVar2.dXz.result);
                    Bundle bundle = new Bundle();
                    bundle.putString("file_path", qzVar2.dXz.filePath);
                    bundle.putString("result", qzVar2.dXz.result);
                    bundle.putInt("code_type", qzVar2.dXz.dFL);
                    bundle.putInt("code_version", qzVar2.dXz.dFM);
                    d.this.hnd.bn(bundle);
                    AppMethodBeat.o(78453);
                } else {
                    AppMethodBeat.o(78453);
                }
                return false;
            }
        };
        private com.tencent.mm.ipcinvoker.d hnd;

        private d() {
            AppMethodBeat.i(78456);
            AppMethodBeat.o(78456);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            int i2;
            AppMethodBeat.i(78457);
            Bundle bundle2 = bundle;
            this.hnd = dVar;
            int i3 = bundle2.getInt("type");
            String string = bundle2.getString("img_path");
            int i4 = bundle2.getInt("x_down");
            int i5 = bundle2.getInt("y_down");
            switch (i3) {
                case 1:
                    if (this.IUV == null) {
                        this.IUV = new HashMap();
                        EventCenter.instance.addListener(this.hms);
                        EventCenter.instance.addListener(this.IUW);
                    }
                    ad.b G = com.tencent.mm.model.ad.aVe().G("basescanui@datacenter", true);
                    G.l("key_basescanui_screen_position", Boolean.TRUE);
                    G.l("key_basescanui_screen_x", Float.valueOf((float) i4));
                    G.l("key_basescanui_screen_y", Float.valueOf((float) i5));
                    qx qxVar = new qx();
                    qxVar.dXu.filePath = string;
                    qxVar.dXu.dDZ = System.currentTimeMillis();
                    EventCenter.instance.publish(qxVar);
                    this.IUV.put(string, 1);
                    AppMethodBeat.o(78457);
                    return;
                case 2:
                    if (this.IUV == null || !this.IUV.containsKey(string)) {
                        Log.e("MicroMsg.QBarLogicTask", "%s is not recognizing", string);
                        AppMethodBeat.o(78457);
                        return;
                    }
                    ax axVar = new ax();
                    axVar.dDY.filePath = string;
                    EventCenter.instance.publish(axVar);
                    this.IUV.remove(string);
                    com.tencent.mm.vfs.s.deleteFile(string);
                    AppMethodBeat.o(78457);
                    return;
                case 3:
                    String string2 = bundle2.getString("result");
                    String string3 = bundle2.getString("url");
                    String string4 = bundle2.getString("imageUrl");
                    int i6 = bundle2.getInt("codeType");
                    int i7 = bundle2.getInt("codeVersion");
                    Intent intent = new Intent();
                    intent.setClass(MMApplicationContext.getContext(), WebviewScanImageActivity.class);
                    intent.setFlags(872415232);
                    intent.putExtra("key_string_for_scan", string2);
                    intent.putExtra("key_string_for_url", string3);
                    intent.putExtra("key_string_for_image_url", string4);
                    intent.putExtra("key_codetype_for_scan", i6);
                    intent.putExtra("key_codeversion_for_scan", i7);
                    String string5 = bundle2.getString("preUsername");
                    String string6 = bundle2.getString("preChatName");
                    String string7 = bundle2.getString("rawUrl");
                    String JX = com.tencent.mm.model.ad.JX("WebviewQrCode");
                    ad.b G2 = com.tencent.mm.model.ad.aVe().G(JX, true);
                    G2.l("preUsername", string5);
                    G2.l("preChatName", string6);
                    G2.l("url", string3);
                    if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(string3)) {
                        i2 = 6;
                    } else {
                        i2 = 1;
                    }
                    G2.l("Contact_Sub_Scene", Integer.valueOf(i2));
                    G2.l("Contact_Scene_Note", string3);
                    G2.l("rawUrl", string7);
                    intent.putExtra("img_gallery_session_id", JX);
                    String string8 = bundle2.getString("pre_username");
                    if (string8 != null && ab.IT(string8)) {
                        intent.putExtra("key_string_for_from_username", string8);
                    }
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$QBarLogicTask", "reqDealQBarResult", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$QBarLogicTask", "reqDealQBarResult", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(78457);
                    return;
                case 4:
                    String string9 = bundle2.getString("wxa_result");
                    int i8 = bundle2.getInt("wxa_code_type", 0);
                    if (!Util.isNullOrNil(string9)) {
                        new com.tencent.mm.plugin.scanner.d().bZ(i8, string9).a(new d.b<bws>() {
                            /* class com.tencent.mm.plugin.webview.luggage.s.d.AnonymousClass3 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.g.d.b
                            public final /* synthetic */ void bz(bws bws) {
                                AppMethodBeat.i(78455);
                                bws bws2 = bws;
                                Bundle bundle = new Bundle();
                                if (bws2 == null) {
                                    bundle.putInt("key_resp_ret", -1);
                                    d.this.hnd.bn(bundle);
                                    AppMethodBeat.o(78455);
                                    return;
                                }
                                try {
                                    byte[] byteArray = bws2.toByteArray();
                                    Log.i("MicroMsg.QBarLogicTask", "response bytes len = %d ", Integer.valueOf(byteArray.length));
                                    bundle.putInt("key_resp_ret", 0);
                                    bundle.putByteArray("key_resp_item_bytes", byteArray);
                                    d.this.hnd.bn(bundle);
                                    AppMethodBeat.o(78455);
                                } catch (IOException e2) {
                                    Log.e("MicroMsg.QBarLogicTask", e2.getMessage());
                                    AppMethodBeat.o(78455);
                                }
                            }
                        });
                        break;
                    } else {
                        Log.e("MicroMsg.QBarLogicTask", "resultStr is null");
                        AppMethodBeat.o(78457);
                        return;
                    }
            }
            AppMethodBeat.o(78457);
        }
    }

    static final class c {
        final int id;
        final String title;

        public c(int i2, String str) {
            this.id = i2;
            this.title = str;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(WebView.b bVar) {
        AppMethodBeat.i(78464);
        boolean aYx = aYx(bVar.mExtra);
        if (Util.isNullOrNil(this.mHk) && gcf()) {
            this.mHq = bVar;
            this.mHo = new h();
            this.mHo.a(this.ISU.ITd, this.mHw);
        }
        AppMethodBeat.o(78464);
        return aYx;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(WebView.b bVar) {
        AppMethodBeat.i(78465);
        boolean aYx = aYx(bVar.mExtra);
        if (Util.isNullOrNil(this.mHk) && gcf()) {
            this.mHp = bVar;
            this.mHo = new h();
            this.mHo.a(this.ISU.ITd, this.mHw);
        }
        AppMethodBeat.o(78465);
        return aYx;
    }
}
