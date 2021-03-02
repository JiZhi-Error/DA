package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;

public final class a implements h.b {
    h.a BHR;
    int BIO;
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass2 */

        public final void onClick(View view) {
            Bundle bundleExtra;
            AppMethodBeat.i(28001);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.record.ui.a.b bVar2 = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Log.d("justin", "ImageViewWrapper clickListener %s", Integer.valueOf(bVar2.dataType));
            switch (bVar2.dataType) {
                case 0:
                    Intent intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", bVar2.msgId);
                    intent.putExtra("record_data_id", bVar2.dKT.dLl);
                    intent.putExtra("record_xml", bVar2.dXH);
                    if (!(!(view.getContext() instanceof Activity) || ((Activity) view.getContext()).getIntent() == null || (bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj")) == null)) {
                        intent.putExtra("_stat_obj", bundleExtra);
                    }
                    Context context = view.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                case 1:
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_detail_info_id", bVar2.qNT.field_localId);
                    intent2.putExtra("key_detail_data_id", bVar2.dKT.dLl);
                    com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.FavImgGalleryUI", intent2, 1);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28001);
        }
    };
    private int displayWidth = 0;
    ScanCodeSheetItemLogic mHu;
    private ListView mListView;
    Map<String, C1631a> teB = new HashMap();
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass6 */

        {
            AppMethodBeat.i(161429);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(161429);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(28009);
            qz qzVar2 = qzVar;
            String str = qzVar2.dXz.filePath;
            C1631a aVar = new C1631a((byte) 0);
            aVar.teQ = qzVar2;
            a.this.teB.put(str, aVar);
            if (a.this.tiF != null && a.this.tiF.isShowing()) {
                a.this.tib.onLongClick(null);
            }
            AppMethodBeat.o(28009);
            return true;
        }
    };
    e tiF;
    View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3 */
        private com.tencent.mm.plugin.record.ui.a.b BIQ;
        private aml BIR;
        private Context context;
        private String path;
        private g tbr;

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(28004);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (view != null) {
                this.context = view.getContext();
                this.BIQ = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                this.tbr = this.BIQ.qNT;
                this.BIR = this.BIQ.dKT;
            }
            hb hbVar = new hb();
            hbVar.dLm.type = 2;
            hbVar.dLm.dLo = this.BIQ.dKT;
            EventCenter.instance.publish(hbVar);
            this.path = hbVar.dLn.path;
            if (!s.YS(this.path)) {
                Log.w("MicroMsg.ImageViewWrapper", "file not exists");
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(28004);
            } else {
                if (a.this.tiF == null) {
                    a.this.tiF = new e(this.context, 1, false);
                }
                a.this.tiF.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(28002);
                        mVar.clear();
                        a.this.tiF.setFooterView(null);
                        if (AnonymousClass3.this.BIR.Lwv == 0) {
                            if (AnonymousClass3.this.tbr.cUu()) {
                                mVar.d(2, AnonymousClass3.this.context.getString(R.string.cc8));
                            }
                            if (AnonymousClass3.this.tbr.cUv()) {
                                mVar.d(1, AnonymousClass3.this.context.getString(R.string.cau));
                            }
                            mVar.d(3, AnonymousClass3.this.context.getString(R.string.cc1));
                            C1631a aVar = a.this.teB.get(AnonymousClass3.this.path);
                            if (aVar == null || aVar.teQ == null) {
                                qx qxVar = new qx();
                                qxVar.dXu.dDZ = System.currentTimeMillis();
                                qxVar.dXu.filePath = AnonymousClass3.this.path;
                                EventCenter.instance.publish(qxVar);
                            } else if (!Util.isNullOrNil(aVar.teQ.dXz.result)) {
                                e eVar = a.this.tiF;
                                a aVar2 = a.this;
                                Context context = AnonymousClass3.this.context;
                                qz qzVar = aVar.teQ;
                                AnonymousClass4 r5 = new View.OnClickListener(qzVar, context) {
                                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass4 */
                                    final /* synthetic */ qz teK;
                                    final /* synthetic */ Context val$context;

                                    {
                                        this.teK = r2;
                                        this.val$context = r3;
                                    }

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(28005);
                                        b bVar = new b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        Log.i("MicroMsg.ImageViewWrapper", "request deal QBAR string");
                                        if (a.this.tiF.isShowing()) {
                                            a.this.tiF.bMo();
                                        }
                                        if (this.teK == null) {
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(28005);
                                            return;
                                        }
                                        cr crVar = new cr();
                                        crVar.dFK.activity = (Activity) this.val$context;
                                        crVar.dFK.dDX = this.teK.dXz.result;
                                        crVar.dFK.dFL = this.teK.dXz.dFL;
                                        crVar.dFK.dFM = this.teK.dXz.dFM;
                                        EventCenter.instance.publish(crVar);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(28005);
                                    }
                                };
                                if (!aVar.BJa) {
                                    aVar.BJa = true;
                                    aVar2.mHu.cm(qzVar.dXz.dFL, qzVar.dXz.result);
                                }
                                eVar.setFooterView(aVar2.mHu.a(r5, qzVar.dXz.dFL, qzVar.dXz.result, 5));
                                AppMethodBeat.o(28002);
                                return;
                            }
                        }
                        AppMethodBeat.o(28002);
                    }
                };
                a.this.tiF.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(28003);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                intent.putExtra("Ksnsupload_type", 0);
                                intent.putExtra("sns_kemdia_path", AnonymousClass3.this.path);
                                String JX = ad.JX("fav_");
                                ad.aVe().G(JX, true).l("prePublishId", "fav_");
                                intent.putExtra("reportSessionId", JX);
                                c.b(AnonymousClass3.this.context, "sns", ".ui.SnsUploadUI", intent);
                                AppMethodBeat.o(28003);
                                return;
                            case 2:
                                com.tencent.mm.plugin.fav.a.b.a(AnonymousClass3.this.path, AnonymousClass3.this.context, AnonymousClass3.this.BIQ.dKT.jsz);
                                AppMethodBeat.o(28003);
                                return;
                            case 3:
                                p.a(AnonymousClass3.this.context, AnonymousClass3.this.path, new p.a() {
                                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                    @Override // com.tencent.mm.platformtools.p.a
                                    public final void bP(String str, final String str2) {
                                        AppMethodBeat.i(232048);
                                        Toast.makeText(AnonymousClass3.this.context, AnonymousClass3.this.context.getString(R.string.bjr, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                                        com.tencent.f.h.RTc.aX(new Runnable() {
                                            /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(232047);
                                                String bhK = s.bhK(str2);
                                                v vVar = v.jNy;
                                                v.bR(bhK, AnonymousClass3.this.BIQ.dKT.jsz);
                                                AppMethodBeat.o(232047);
                                            }
                                        });
                                        AppMethodBeat.o(232048);
                                    }

                                    @Override // com.tencent.mm.platformtools.p.a
                                    public final void bQ(String str, String str2) {
                                        AppMethodBeat.i(232049);
                                        Toast.makeText(AnonymousClass3.this.context, AnonymousClass3.this.context.getString(R.string.cc0), 1).show();
                                        AppMethodBeat.o(232049);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(28003);
                    }
                };
                a.this.tiF.PGl = new e.b() {
                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass3.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(232050);
                        a.this.mHu.onDismiss();
                        AppMethodBeat.o(232050);
                    }
                };
                a.this.tiF.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(28004);
            }
            return true;
        }
    };

    public a(h.a aVar, ListView listView) {
        AppMethodBeat.i(28010);
        this.BHR = aVar;
        this.mListView = listView;
        EventCenter.instance.addListener(this.teF);
        this.mHu = new ScanCodeSheetItemLogic(listView.getContext(), new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(28000);
                if (a.this.tiF != null && a.this.tiF.isShowing()) {
                    a.this.tib.onLongClick(null);
                }
                AppMethodBeat.o(28000);
            }
        });
        AppMethodBeat.o(28010);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final View createView(Context context) {
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(28011);
        View inflate = View.inflate(context, R.layout.bll, null);
        if (context == null || !(context instanceof MMActivity)) {
            displayMetrics = MMApplicationContext.getResources().getDisplayMetrics();
        } else {
            displayMetrics = ((MMActivity) context).getOriginalResources().getDisplayMetrics();
        }
        this.displayWidth = displayMetrics.widthPixels - at.fromDPToPix(context, 80);
        this.displayWidth = Math.max(this.displayWidth, 0);
        if (this.displayWidth == 0) {
            this.displayWidth = at.fromDPToPix(context, 320);
        }
        this.BIO = this.displayWidth;
        AppMethodBeat.o(28011);
        return inflate;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void a(View view, int i2, final com.tencent.mm.plugin.record.ui.a.b bVar, Object obj) {
        AppMethodBeat.i(28012);
        final ImageView imageView = (ImageView) view.findViewById(R.id.gx4);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.epo);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.dec);
        if (bVar.dataType == 1) {
            imageView.setOnLongClickListener(this.tib);
        }
        h.a.b bVar2 = new h.a.b();
        if (bVar.dataType == 0) {
            bVar2.BHU = bVar.msgId;
        } else if (bVar.dataType == 1) {
            bVar2.BHU = bVar.qNT.field_localId;
        }
        bVar2.dKT = bVar.dKT;
        bVar2.dKW = true;
        bVar2.maxWidth = this.displayWidth;
        Bitmap a2 = this.BHR.a(bVar2);
        if (a2 != null) {
            Log.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", bVar2.dKT.dLl, a2);
            a(imageView, progressBar, a2, true, bVar.dKT.dLl);
            AppMethodBeat.o(28012);
            return;
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass5 */

            public final void run() {
                int i2;
                final Bitmap bitmap;
                Bitmap bitmap2;
                AppMethodBeat.i(28007);
                com.tencent.mm.plugin.record.ui.a.a aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                if (aVar.dataType == 0) {
                    if (com.tencent.mm.plugin.record.b.p.g(aVar.dKT, aVar.msgId)) {
                        i2 = R.raw.record_errpicture_icon;
                    }
                    i2 = -1;
                } else {
                    if (aVar.dataType == 1 && Util.isNullOrNil(aVar.dKT.KuR)) {
                        i2 = R.raw.record_errpicture_icon;
                    }
                    i2 = -1;
                }
                final int i3 = i2 == -1 ? R.raw.fav_list_img_default : i2;
                com.tencent.mm.plugin.record.ui.a.a aVar2 = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                h.a aVar3 = a.this.BHR;
                int i4 = a.this.BIO;
                h.a.b bVar = new h.a.b();
                bVar.dKT = aVar2.dKT;
                bVar.dKW = false;
                bVar.maxWidth = i4;
                h.a.c cVar = new h.a.c();
                cVar.dKT = aVar2.dKT;
                if (aVar2.dataType == 0) {
                    if (!com.tencent.mm.plugin.record.b.p.g(aVar2.dKT, aVar2.msgId)) {
                        bVar.BHU = aVar2.msgId;
                        bitmap2 = aVar3.a(bVar);
                        aVar2.BIM = true;
                        if (bitmap2 == null) {
                            cVar.BHU = aVar2.msgId;
                            Bitmap a2 = aVar3.a(cVar);
                            aVar2.BIM = false;
                            bitmap = a2;
                        }
                        bitmap = bitmap2;
                    }
                    bitmap = null;
                } else {
                    if (aVar2.dataType == 1) {
                        bVar.BHU = aVar2.qNT.field_localId;
                        bVar.dKX = false;
                        bitmap2 = aVar3.a(bVar);
                        aVar2.BIM = true;
                        if (bitmap2 == null) {
                            cVar.BHU = aVar2.qNT.field_localId;
                            bitmap2 = aVar3.a(cVar);
                            aVar2.BIM = false;
                        }
                        bitmap = bitmap2;
                    }
                    bitmap = null;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.b.a.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(28006);
                        a.this.a(imageView, progressBar, bitmap, ((com.tencent.mm.plugin.record.ui.a.a) bVar).BIM, bVar.dKT.dLl);
                        AppMethodBeat.o(28006);
                    }
                });
                AppMethodBeat.o(28007);
            }

            public final String toString() {
                AppMethodBeat.i(28008);
                String str = super.toString() + "|fillView";
                AppMethodBeat.o(28008);
                return str;
            }
        });
        AppMethodBeat.o(28012);
    }

    /* access modifiers changed from: package-private */
    public final void a(ImageView imageView, ProgressBar progressBar, Bitmap bitmap, boolean z, String str) {
        int aH;
        int i2;
        float f2;
        AppMethodBeat.i(232051);
        if (!((com.tencent.mm.plugin.record.ui.a.b) imageView.getTag()).dKT.dLl.equals(str)) {
            Log.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", str, imageView.getTag());
            AppMethodBeat.o(232051);
        } else if (bitmap == null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = this.displayWidth;
            layoutParams.width = this.displayWidth;
            imageView.setBackgroundResource(R.color.f3044b);
            progressBar.setVisibility(0);
            AppMethodBeat.o(232051);
        } else {
            progressBar.setVisibility(8);
            Log.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()));
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (height >= width) {
                float f3 = ((float) height) / ((float) width);
                if (z) {
                    i2 = this.displayWidth;
                    aH = (int) (((float) (bitmap.getHeight() * i2)) / ((float) bitmap.getWidth()));
                } else {
                    if (((double) f3) > 2.5d) {
                        bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                        f2 = 2.5f;
                    } else {
                        f2 = f3;
                    }
                    if (f2 <= 2.0f) {
                        aH = com.tencent.mm.cb.a.aH(imageView.getContext(), R.dimen.a6);
                        i2 = (int) (((float) aH) / f2);
                    } else {
                        i2 = com.tencent.mm.cb.a.aH(imageView.getContext(), R.dimen.a8);
                        aH = (int) (((float) i2) * f2);
                    }
                }
            } else {
                float f4 = ((float) width) / ((float) height);
                if (f4 > 2.33f) {
                    bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.33f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.33f), bitmap.getHeight());
                }
                if (z) {
                    i2 = this.displayWidth;
                    aH = (int) (((float) (bitmap.getHeight() * i2)) / ((float) bitmap.getWidth()));
                } else if (f4 <= 2.0f) {
                    i2 = com.tencent.mm.cb.a.aH(imageView.getContext(), R.dimen.a6);
                    aH = (int) (((float) i2) / f4);
                } else {
                    aH = com.tencent.mm.cb.a.aH(imageView.getContext(), R.dimen.a8);
                    i2 = (int) (((float) aH) * f4);
                }
            }
            layoutParams2.width = i2;
            layoutParams2.height = aH;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ForceGpuUtil.decideLayerType(imageView, i2, aH);
            if (imageView.getLayerType() == 1) {
                this.mListView.setLayerType(1, null);
            }
            imageView.setImageBitmap(bitmap);
            imageView.setBackgroundResource(0);
            AppMethodBeat.o(232051);
        }
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void destroy() {
        AppMethodBeat.i(28014);
        EventCenter.instance.removeListener(this.teF);
        AppMethodBeat.o(28014);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void pause() {
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.b.a$a  reason: collision with other inner class name */
    static final class C1631a {
        boolean BJa;
        qz teQ;
        boolean tiI;

        private C1631a() {
            this.tiI = false;
        }

        /* synthetic */ C1631a(byte b2) {
            this();
        }
    }
}
