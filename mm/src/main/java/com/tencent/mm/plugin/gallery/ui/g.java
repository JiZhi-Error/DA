package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class g extends RecyclerView.a<a> implements View.OnClickListener {
    private Context mContext;
    private int vLx = -1;
    private int vLy = -1;
    private int vLz;
    private boolean xpA;
    private ArrayList<String> xqv;
    d xrl;
    private int xrm;
    ArrayList<String> xrn = new ArrayList<>();
    b xro;
    private int xrp;
    private Drawable xrq;
    android.support.v7.widget.a.a xrr = new android.support.v7.widget.a.a(new a.AbstractC0053a() {
        /* class com.tencent.mm.plugin.gallery.ui.g.AnonymousClass1 */
        int eeE = -1;

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
            AppMethodBeat.i(164810);
            int lR = vVar.lR();
            int lR2 = vVar2.lR();
            g.this.ar(lR, lR2);
            if (g.this.xro != null) {
                g.this.xro.gI(lR, lR2);
            }
            g.this.vLy = lR2;
            AppMethodBeat.o(164810);
            return false;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void f(final RecyclerView.v vVar, final int i2) {
            AppMethodBeat.i(111641);
            super.f(vVar, i2);
            if (vVar != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(g.this.mContext, R.anim.cs);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.gallery.ui.g.AnonymousClass1.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(111638);
                        if (i2 == 2) {
                            g.this.vLx = g.this.vLy = vVar.lR();
                            AnonymousClass1.this.eeE = g.this.vLz;
                            Log.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", Integer.valueOf(AnonymousClass1.this.eeE));
                        }
                        AppMethodBeat.o(111638);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) vVar).convertView.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(111641);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(111642);
            if (vVar != null) {
                super.d(recyclerView, vVar);
                Animation loadAnimation = AnimationUtils.loadAnimation(g.this.mContext, R.anim.cr);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.gallery.ui.g.AnonymousClass1.AnonymousClass2 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(111639);
                        d.swap(g.this.xrn, g.this.vLx, g.this.vLy);
                        if (g.this.xro != null) {
                            if (AnonymousClass1.this.eeE > g.this.vLx && AnonymousClass1.this.eeE <= g.this.vLy) {
                                g.this.xro.ak(g.this.vLx, g.this.vLy, AnonymousClass1.this.eeE - 1);
                                AppMethodBeat.o(111639);
                                return;
                            } else if (AnonymousClass1.this.eeE < g.this.vLx && AnonymousClass1.this.eeE >= g.this.vLy) {
                                g.this.xro.ak(g.this.vLx, g.this.vLy, AnonymousClass1.this.eeE + 1);
                                AppMethodBeat.o(111639);
                                return;
                            } else if (g.this.vLx == AnonymousClass1.this.eeE) {
                                g.this.xro.ak(g.this.vLx, g.this.vLy, g.this.vLy);
                                AppMethodBeat.o(111639);
                                return;
                            } else {
                                g.this.xro.ak(g.this.vLx, g.this.vLy, AnonymousClass1.this.eeE);
                            }
                        }
                        AppMethodBeat.o(111639);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) vVar).convertView.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(111642);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void N(RecyclerView.v vVar) {
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final float M(RecyclerView.v vVar) {
            return 0.295858f;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            AppMethodBeat.i(111643);
            super.a(canvas, recyclerView, vVar, f2 / 1.3f, f3 / 1.3f, i2, z);
            AppMethodBeat.o(111643);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(179475);
            int db = db(51);
            AppMethodBeat.o(179475);
            return db;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean nq() {
            return true;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean nr() {
            return false;
        }
    });

    public interface b {
        void NV(int i2);

        void ak(int i2, int i3, int i4);

        void gI(int i2, int i3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(111656);
        a(aVar, i2);
        AppMethodBeat.o(111656);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2, List list) {
        AppMethodBeat.i(111655);
        a aVar2 = aVar;
        if (list.isEmpty()) {
            a(aVar2, i2);
            AppMethodBeat.o(111655);
            return;
        }
        GalleryItem.MediaItem a2 = a(i2, aVar2);
        if (a2 == null) {
            AppMethodBeat.o(111655);
            return;
        }
        c(aVar2.xrw, a2.xiW, i2);
        AppMethodBeat.o(111655);
    }

    public final void gJ(int i2, int i3) {
        this.vLz = i2;
        this.xrp = i3;
    }

    public g(Context context, ArrayList<String> arrayList, int i2, boolean z) {
        AppMethodBeat.i(111646);
        this.mContext = context;
        this.xqv = arrayList;
        this.xrn.addAll(arrayList);
        this.xrm = i2;
        this.xpA = z;
        if (e.dQK().mcq == 15) {
            this.xrq = context.getResources().getDrawable(R.drawable.a69);
            AppMethodBeat.o(111646);
            return;
        }
        this.xrq = context.getResources().getDrawable(R.drawable.s7);
        AppMethodBeat.o(111646);
    }

    public final void aze(String str) {
        AppMethodBeat.i(111647);
        this.xrn.add(str);
        AppMethodBeat.o(111647);
    }

    public final int indexOf(String str) {
        AppMethodBeat.i(111648);
        int indexOf = this.xrn.indexOf(str);
        AppMethodBeat.o(111648);
        return indexOf;
    }

    public final void remove(int i2) {
        AppMethodBeat.i(111649);
        this.xrn.remove(i2);
        AppMethodBeat.o(111649);
    }

    private void a(final a aVar, int i2) {
        AppMethodBeat.i(111650);
        GalleryItem.MediaItem a2 = a(i2, aVar);
        if (a2 == null) {
            Log.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            AppMethodBeat.o(111650);
            return;
        }
        ViewGroup.LayoutParams layoutParams = aVar.convertView.getLayoutParams();
        int i3 = this.xrm;
        layoutParams.width = i3;
        layoutParams.height = i3;
        c(aVar.xrw, a2.xiW, i2);
        aVar.convertView.setOnClickListener(this);
        if (this.xpA) {
            aVar.convertView.setTag(Integer.valueOf(aVar.xrC));
        } else {
            aVar.convertView.setTag(a2.xiW);
        }
        if (a2.getType() == 2) {
            aVar.xrx.setVisibility(0);
            int round = Math.round(((float) ((long) ((GalleryItem.VideoMediaItem) a2).jkS)) / 1000.0f);
            aVar.xry.setText(String.format(Locale.CHINA, "%d:%02d", Integer.valueOf(round / 60), Integer.valueOf(round % 60)));
        } else {
            aVar.xrx.setVisibility(8);
        }
        String aQn = a2.aQn();
        String str = a2.xiW;
        if (!Util.isNullOrNil(aQn) || !Util.isNullOrNil(str)) {
            h.a(aVar.xdY, a2.getType(), aQn, str, a2.xiZ, new h.a() {
                /* class com.tencent.mm.plugin.gallery.ui.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.gallery.ui.h.a
                public final void dSs() {
                    AppMethodBeat.i(111644);
                    Log.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", Integer.valueOf(aVar.xdY.getWidth()), Integer.valueOf(aVar.xdY.getHeight()));
                    AppMethodBeat.o(111644);
                }
            }, a2.xja);
            if ((e.dQK().mcq == 3 || e.dQK().mcq == 11) && a2 != null && a2.mMimeType.equalsIgnoreCase("image/gif")) {
                aVar.xrz.setVisibility(0);
            } else {
                aVar.xrz.setVisibility(8);
            }
            if (a2.mMimeType.equalsIgnoreCase("edit")) {
                aVar.xrA.setVisibility(0);
            } else {
                aVar.xrA.setVisibility(8);
            }
            aVar.xrB.setVisibility(8);
            AppMethodBeat.o(111650);
            return;
        }
        Log.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(111650);
    }

    private void c(ImageView imageView, String str, int i2) {
        boolean z;
        AppMethodBeat.i(111651);
        if (this.xqv.contains(str)) {
            imageView.setBackground(null);
            imageView.setImageDrawable(this.xrq);
            z = false;
        } else {
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
            z = true;
        }
        imageView.setVisibility(0);
        if (!Util.isNullOrNil(this.xrl.getItem(this.xrp)) && this.xrl.getItem(this.xrp).equals(str)) {
            imageView.setVisibility(0);
            if (z && i2 == this.vLz) {
                imageView.setImageDrawable(this.xrq);
                AppMethodBeat.o(111651);
                return;
            }
        } else if (!Util.isNullOrNil(this.xrl.getItem(this.xrp)) && !this.xrl.getItem(this.xrp).equals(str)) {
            if (i2 != this.vLz && !z) {
                imageView.setVisibility(8);
                AppMethodBeat.o(111651);
                return;
            } else if (i2 == this.vLz && !z) {
                imageView.setImageDrawable(this.xrq);
            }
        }
        AppMethodBeat.o(111651);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(111652);
        int size = this.xrn.size();
        AppMethodBeat.o(111652);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(111653);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.xro != null) {
            if (this.xpA) {
                this.xro.NV(((Integer) view.getTag()).intValue());
            } else {
                this.xro.NV(this.xrn.indexOf(view.getTag()));
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111653);
    }

    private GalleryItem.MediaItem a(int i2, a aVar) {
        GalleryItem.MediaItem a2;
        AppMethodBeat.i(111654);
        if (i2 < 0 || i2 >= this.xrn.size()) {
            Log.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i2), Integer.valueOf(this.xrn.size()));
            AppMethodBeat.o(111654);
            return null;
        }
        String str = this.xrn.get(i2);
        if (this.xpA) {
            if (this.xrl.xno != null) {
                GalleryItem.MediaItem a3 = GalleryItem.MediaItem.a(0, 0, str, str, "");
                int indexOf = this.xrl.xno.indexOf(a3);
                if (indexOf < 0) {
                    Iterator<GalleryItem.MediaItem> it = e.dQP().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            a2 = null;
                            break;
                        }
                        a2 = it.next();
                        if (a2.equals(a3)) {
                            Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", a2.xiW);
                            break;
                        }
                    }
                } else {
                    aVar.xrC = indexOf;
                    a2 = this.xrl.xno.get(indexOf);
                }
            } else {
                a2 = null;
            }
        } else if (e.dQM() != null) {
            GalleryItem.MediaItem a4 = GalleryItem.MediaItem.a(0, 0, str, str, "");
            int indexOf2 = e.dQM().indexOf(a4);
            if (indexOf2 < 0) {
                Iterator<GalleryItem.MediaItem> it2 = e.dQP().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        a2 = null;
                        break;
                    }
                    a2 = it2.next();
                    if (a2.equals(a4)) {
                        Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", a2.xiW);
                        break;
                    }
                }
            } else {
                a2 = e.dQM().get(indexOf2);
            }
        } else {
            a2 = GalleryItem.MediaItem.a(1, 0, str, str, "");
        }
        AppMethodBeat.o(111654);
        return a2;
    }

    public static class a extends RecyclerView.v {
        public View convertView;
        public ImageView xdY;
        public ImageView xnz;
        public ImageView xrA;
        public ImageView xrB;
        public int xrC;
        public ImageView xrw;
        public RelativeLayout xrx;
        public TextView xry;
        public ImageView xrz;

        public a(View view) {
            super(view);
            AppMethodBeat.i(111645);
            this.convertView = view;
            this.xrz = (ImageView) view.findViewById(R.id.dk1);
            this.xrA = (ImageView) view.findViewById(R.id.bvx);
            this.xrB = (ImageView) view.findViewById(R.id.c4n);
            this.xrw = (ImageView) view.findViewById(R.id.fbw);
            this.xdY = (ImageView) view.findViewById(R.id.fc1);
            this.xrx = (RelativeLayout) view.findViewById(R.id.j5b);
            this.xry = (TextView) view.findViewById(R.id.j5d);
            this.xnz = (ImageView) view.findViewById(R.id.fbr);
            this.xnz.setBackgroundResource(R.color.u_);
            this.xnz.setVisibility(8);
            AppMethodBeat.o(111645);
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(111657);
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.bio, viewGroup, false));
        AppMethodBeat.o(111657);
        return aVar;
    }
}
