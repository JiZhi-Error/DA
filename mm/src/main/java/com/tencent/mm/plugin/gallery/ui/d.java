package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class d extends v {
    int bNu = -1;
    private Bitmap dku = null;
    int eeE = -1;
    private HashMap<String, WeakReference<b>> kwA = new HashMap<>();
    Context mContext;
    ArrayList<GalleryItem.MediaItem> xno = new ArrayList<>();
    boolean xpA;
    HashSet<String> xpB = new HashSet<>();
    View xpC = null;
    boolean xpD = false;
    private boolean xpE = true;
    public f xpF = new f(this);
    public e xpG = new e(this);
    ArrayList<String> xpz = new ArrayList<>();

    public d(Context context) {
        AppMethodBeat.i(111516);
        this.mContext = context;
        AppMethodBeat.o(111516);
    }

    @Override // com.tencent.mm.ui.base.v, android.support.v4.view.q
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(111517);
        if (!this.xpA) {
            Log.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", Integer.valueOf(i2), Integer.valueOf(this.eeE));
            if (i2 != this.eeE || !this.xpD) {
                Object instantiateItem = super.instantiateItem(viewGroup, i2);
                AppMethodBeat.o(111517);
                return instantiateItem;
            }
            Log.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
            this.OUz.put(this.xpC, Integer.valueOf(this.eeE));
            this.OUA.put(this.eeE, this.xpC);
            this.eeE = -1;
            this.xpD = false;
            View view = this.xpC;
            AppMethodBeat.o(111517);
            return view;
        }
        Object instantiateItem2 = super.instantiateItem(viewGroup, i2);
        AppMethodBeat.o(111517);
        return instantiateItem2;
    }

    @Override // com.tencent.mm.ui.base.v, android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(111518);
        if (this.xpA) {
            viewGroup.removeView((View) obj);
            super.destroyItem(viewGroup, i2, obj);
            AppMethodBeat.o(111518);
        } else if (obj == null) {
            Log.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", Integer.valueOf(i2));
            AppMethodBeat.o(111518);
        } else {
            if (this.xpC != null) {
                Log.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", Integer.valueOf(i2), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.xpC.hashCode()));
            }
            if (obj != this.xpC || !this.xpD) {
                super.destroyItem(viewGroup, i2, obj);
                viewGroup.removeView((View) obj);
                AppMethodBeat.o(111518);
                return;
            }
            Log.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
            AppMethodBeat.o(111518);
        }
    }

    public final void as(ArrayList<String> arrayList) {
        AppMethodBeat.i(111519);
        this.xpz.clear();
        this.xpz.addAll(arrayList);
        reset();
        notifyDataSetChanged();
        AppMethodBeat.o(111519);
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(111520);
        if (this.xpA) {
            int size = this.xno.size();
            AppMethodBeat.o(111520);
            return size;
        }
        int size2 = this.xpz.size();
        AppMethodBeat.o(111520);
        return size2;
    }

    @Override // com.tencent.mm.ui.base.v
    public final MultiTouchImageView NQ(int i2) {
        AppMethodBeat.i(111521);
        View abm = super.abm(i2);
        if (abm == null) {
            Log.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", Integer.valueOf(i2));
            AppMethodBeat.o(111521);
            return null;
        }
        b bVar = (b) abm.getTag();
        if (bVar == null) {
            Log.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", Integer.valueOf(i2));
            AppMethodBeat.o(111521);
            return null;
        } else if (bVar.xpN.getVisibility() == 8) {
            AppMethodBeat.o(111521);
            return null;
        } else {
            MultiTouchImageView multiTouchImageView = bVar.xpN;
            AppMethodBeat.o(111521);
            return multiTouchImageView;
        }
    }

    @Override // com.tencent.mm.ui.base.v
    public final WxImageView NR(int i2) {
        AppMethodBeat.i(111522);
        View abm = super.abm(i2);
        if (abm == null) {
            Log.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition view is null.", Integer.valueOf(i2));
            AppMethodBeat.o(111522);
            return null;
        }
        b bVar = (b) abm.getTag();
        if (bVar == null) {
            Log.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition holder is null.", Integer.valueOf(i2));
            AppMethodBeat.o(111522);
            return null;
        } else if (bVar.xpO.getVisibility() == 8) {
            AppMethodBeat.o(111522);
            return null;
        } else {
            WxImageView wxImageView = bVar.xpO;
            AppMethodBeat.o(111522);
            return wxImageView;
        }
    }

    public final String getItem(int i2) {
        AppMethodBeat.i(111523);
        if (this.xpA) {
            if (i2 < 0 || i2 >= this.xno.size()) {
                Log.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", Integer.valueOf(i2), Integer.valueOf(this.xno.size()));
                AppMethodBeat.o(111523);
                return "";
            }
            String str = this.xno.get(i2).xiW;
            AppMethodBeat.o(111523);
            return str;
        } else if (i2 < 0 || i2 >= this.xpz.size()) {
            Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i2), Integer.valueOf(this.xpz.size()));
            AppMethodBeat.o(111523);
            return "";
        } else {
            String str2 = this.xpz.get(i2);
            AppMethodBeat.o(111523);
            return str2;
        }
    }

    public final GalleryItem.MediaItem NS(int i2) {
        GalleryItem.MediaItem mediaItem;
        GalleryItem.MediaItem mediaItem2;
        int indexOf;
        AppMethodBeat.i(111524);
        if (this.xpA) {
            if (i2 < 0 || i2 >= this.xno.size()) {
                Log.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", Integer.valueOf(i2), Integer.valueOf(this.xno.size()));
                AppMethodBeat.o(111524);
                return null;
            }
            GalleryItem.MediaItem mediaItem3 = this.xno.get(i2);
            AppMethodBeat.o(111524);
            return mediaItem3;
        } else if (i2 < 0 || i2 >= this.xpz.size()) {
            Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i2), Integer.valueOf(this.xpz.size()));
            AppMethodBeat.o(111524);
            return null;
        } else {
            String str = this.xpz.get(i2);
            GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(0, 0, str, str, "");
            if (e.dQM() == null || (indexOf = e.dQM().indexOf(a2)) < 0) {
                mediaItem = null;
            } else {
                mediaItem = e.dQM().get(indexOf);
            }
            if (mediaItem == null && !e.dQP().isEmpty()) {
                Iterator<GalleryItem.MediaItem> it = e.dQP().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    mediaItem2 = it.next();
                    if (mediaItem2.equals(a2)) {
                        break;
                    }
                }
            }
            mediaItem2 = mediaItem;
            AppMethodBeat.o(111524);
            return mediaItem2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        ImageView tlC;
        boolean xpM = false;
        MultiTouchImageView xpN;
        WxImageView xpO;
        TextView xpP;
        TextView xpQ;

        b() {
        }
    }

    class a implements View.OnClickListener {
        private String filePath;

        public a(String str) {
            this.filePath = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(111515);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            FileProviderHelper.setIntentDataAndType(d.this.mContext, intent, new o(this.filePath), "video/*", false);
            try {
                Context context = d.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111515);
        }
    }

    public final void a(MultiTouchImageView multiTouchImageView, String str, Bitmap bitmap) {
        b bVar;
        AppMethodBeat.i(111525);
        this.xpB.remove(str);
        if (!(multiTouchImageView == null || (bVar = (b) multiTouchImageView.getTag()) == null)) {
            if (bitmap != null) {
                a(bVar, bitmap);
                if (bVar.xpQ != null) {
                    bVar.xpQ.setText("");
                    bVar.xpQ.setVisibility(8);
                    AppMethodBeat.o(111525);
                    return;
                }
            } else if (bVar.xpM && bVar.xpQ != null) {
                bVar.xpQ.setText(str);
                bVar.xpQ.setVisibility(0);
                AppMethodBeat.o(111525);
                return;
            } else if (bVar.xpQ != null) {
                bVar.xpQ.setText("");
                bVar.xpQ.setVisibility(8);
            }
        }
        AppMethodBeat.o(111525);
    }

    @TargetApi(11)
    protected static void a(b bVar, Bitmap bitmap) {
        AppMethodBeat.i(111526);
        Log.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", Util.getStack());
        bVar.xpN.setVisibility(0);
        bVar.xpO.setVisibility(4);
        bVar.xpN.setMaxZoomLimit(4.5f);
        bVar.xpN.setEnableHorLongBmpMode(false);
        ForceGpuUtil.decideLayerType(bVar.xpN, bitmap.getWidth(), bitmap.getHeight());
        bVar.xpN.cN(bitmap.getWidth(), bitmap.getHeight());
        bVar.xpN.setImageBitmap(bitmap);
        bVar.xpN.requestLayout();
        AppMethodBeat.o(111526);
    }

    public final void release() {
        AppMethodBeat.i(111527);
        detach();
        this.kwA.clear();
        this.xpB.clear();
        AppMethodBeat.o(111527);
    }

    @Override // com.tencent.mm.ui.base.v
    public final void detach() {
        AppMethodBeat.i(111528);
        super.detach();
        this.xpG.detach();
        AppMethodBeat.o(111528);
    }

    @Override // com.tencent.mm.ui.base.v
    public final /* synthetic */ Object h(int i2, View view) {
        final b bVar;
        final String str;
        GalleryItem.VideoMediaItem videoMediaItem;
        String str2;
        int indexOf;
        long j2;
        AppMethodBeat.i(111529);
        long currentTicks = Util.currentTicks();
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.avp, null);
            b bVar2 = new b();
            bVar2.xpN = (MultiTouchImageView) view.findViewById(R.id.dup);
            bVar2.xpO = (WxImageView) view.findViewById(R.id.jrc);
            bVar2.tlC = (ImageView) view.findViewById(R.id.j5b);
            bVar2.xpP = (TextView) view.findViewById(R.id.fbq);
            bVar2.xpQ = (TextView) view.findViewById(R.id.caq);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            b bVar3 = (b) view.getTag();
            bVar3.xpN.setVisibility(4);
            bVar3.xpO.setVisibility(4);
            bVar3.tlC.setVisibility(0);
            bVar3.xpP.setVisibility(8);
            bVar3.xpQ.setVisibility(8);
            bVar = bVar3;
        }
        if (this.xpA) {
            GalleryItem.MediaItem mediaItem = this.xno.get(i2);
            String str3 = mediaItem.xiW;
            str2 = mediaItem.sUB;
            str = str3;
            videoMediaItem = mediaItem;
        } else {
            String str4 = this.xpz.get(i2);
            if (e.dQM() == null || (indexOf = e.dQM().indexOf(GalleryItem.MediaItem.a(0, 0, str4, str4, ""))) < 0) {
                str = str4;
                videoMediaItem = null;
                str2 = null;
            } else {
                str = str4;
                videoMediaItem = e.dQM().get(indexOf);
                str2 = null;
            }
        }
        if (videoMediaItem == null || videoMediaItem.getType() != 2) {
            if (e.dQK().mcq != 3 || videoMediaItem == null || !videoMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.xpP.setVisibility(8);
                bVar.xpM = true;
            } else {
                bVar.xpP.setText(this.mContext.getString(R.string.dlr, Util.getSizeKB(new o(str).length())));
                bVar.xpP.setVisibility(0);
                bVar.xpM = false;
            }
            bVar.tlC.setVisibility(8);
            bVar.tlC.setOnClickListener(null);
            bVar.xpQ.setVisibility(8);
        } else {
            bVar.xpM = false;
            bVar.tlC.setVisibility(0);
            bVar.xpP.setVisibility(8);
            bVar.xpQ.setVisibility(8);
            bVar.tlC.setOnClickListener(new a(str));
            if (e.dQK().mcq == 4 || e.dQK().mcq == 14) {
                t tVar = new t(videoMediaItem.xiW, i2, videoMediaItem, new t.a() {
                    /* class com.tencent.mm.plugin.gallery.ui.d.AnonymousClass1 */
                    WeakReference<TextView> xpH = new WeakReference<>(bVar.xpP);

                    {
                        AppMethodBeat.i(179461);
                        AppMethodBeat.o(179461);
                    }

                    @Override // com.tencent.mm.plugin.gallery.model.t.a
                    public final void a(t tVar) {
                        AppMethodBeat.i(179462);
                        TextView textView = this.xpH.get();
                        if (textView != null && tVar.equals(textView.getTag())) {
                            textView.setTag(null);
                        }
                        AppMethodBeat.o(179462);
                    }
                });
                if (tVar.equals(bVar.xpP.getTag())) {
                    Log.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", 16842794);
                } else {
                    bVar.xpP.setTag(tVar);
                    h.RTc.aX(tVar);
                }
            }
        }
        if (e.dQK().mcq != 3 || ((videoMediaItem != null || !ImgUtil.isGif(str)) && (videoMediaItem == null || !videoMediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            if (videoMediaItem == null) {
                j2 = 0;
            } else {
                j2 = videoMediaItem.xja;
            }
            Log.i("MicroMsg.ImageAdapter", "initImageView, filePath: %s.", str);
            if (this.xpG.xqj.check(str)) {
                Bitmap aT = this.xpG.xqj.aT(str);
                if (!aT.isRecycled()) {
                    a(bVar, aT);
                } else {
                    this.xpG.xqj.remove(str);
                }
            }
            final Bitmap a2 = e.dQJ().a(Util.isNullOrNil(str2) ? str : str2, str, null, j2);
            if (a2 == null || a2.isRecycled()) {
                if (this.dku == null || this.dku.isRecycled()) {
                    this.dku = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ckb);
                }
                a2 = this.dku;
            }
            boolean adl = com.tencent.mm.cq.b.adl(s.k(str, false));
            Log.i("MicroMsg.ImageAdapter", "isSupport: %s, path: %s.", Boolean.valueOf(adl), str);
            if (adl) {
                bVar.xpN.setVisibility(4);
                bVar.xpO.setVisibility(0);
                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                if (imageOptions != null) {
                    int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
                    bVar.xpO.cN(imageOptions.outWidth, imageOptions.outHeight);
                    bVar.xpO.setOrientation(exifOrientation);
                    bVar.xpO.gKy();
                    bVar.xpO.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b() {
                        /* class com.tencent.mm.plugin.gallery.ui.d.AnonymousClass2 */

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void sb() {
                            AppMethodBeat.i(179463);
                            Log.d("MicroMsg.ImageAdapter", "pennqin, wxImageView, on preview loaded.");
                            AppMethodBeat.o(179463);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void n(Bitmap bitmap) {
                            AppMethodBeat.i(179464);
                            Log.d("MicroMsg.ImageAdapter", "pennqin, wxImageView, on image loaded.");
                            AppMethodBeat.o(179464);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void a(c cVar) {
                            AppMethodBeat.i(179465);
                            Log.d("MicroMsg.ImageAdapter", "pennqin, wxImageView, on preview load err.");
                            AppMethodBeat.o(179465);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void b(c cVar) {
                            AppMethodBeat.i(179466);
                            Log.d("MicroMsg.ImageAdapter", "pennqin, wxImageView, on image load err.");
                            com.tencent.mm.cq.c.aqq(cVar.errCode);
                            if (cVar.errCode == 4) {
                                d.a(bVar, a2);
                                if (d.this.xpB.contains(str)) {
                                    AppMethodBeat.o(179466);
                                    return;
                                }
                                d.this.xpB.add(str);
                                bVar.xpN.setTag(bVar);
                                d.this.xpG.a(bVar.xpN, str);
                            }
                            AppMethodBeat.o(179466);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void c(c cVar) {
                            AppMethodBeat.i(179467);
                            Log.d("MicroMsg.ImageAdapter", "pennqin, wxImageView, on tile load err.");
                            AppMethodBeat.o(179467);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void sc() {
                        }
                    });
                    bVar.xpO.a(str, com.davemorrissey.labs.subscaleview.view.a.m(a2));
                }
            } else {
                a(bVar, a2);
                if (!this.xpB.contains(str)) {
                    this.xpB.add(str);
                    bVar.xpN.setTag(bVar);
                    this.xpG.a(bVar.xpN, str);
                }
            }
        } else {
            bVar.xpN.setVisibility(0);
            bVar.xpO.setVisibility(4);
            bVar.xpN.setMaxZoomLimit(1.0f);
            bVar.xpN.setEnableHorLongBmpMode(false);
            bVar.xpN.gKz();
            bVar.xpN.setGifPath(str);
            ForceGpuUtil.decideLayerType(bVar.xpN, bVar.xpN.getImageWidth(), bVar.xpN.getImageHeight());
            MultiTouchImageView multiTouchImageView = bVar.xpN;
            if (multiTouchImageView.OVg && multiTouchImageView.OVh != null) {
                ((com.tencent.mm.ui.g.b.a) multiTouchImageView.OVh).stop();
                ((com.tencent.mm.ui.g.b.a) multiTouchImageView.OVh).start();
            }
        }
        Log.v("MicroMsg.ImageAdapter", "test get view: %d position:%d", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(i2));
        AppMethodBeat.o(111529);
        return view;
    }
}
