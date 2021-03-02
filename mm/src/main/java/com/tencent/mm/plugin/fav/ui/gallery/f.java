package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.gallery.e;
import com.tencent.mm.plugin.fav.ui.gallery.g;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class f extends RecyclerView.a {
    private Runnable dLr;
    private com.tencent.mm.av.a.a.c gzE = null;
    private Context mContext;
    private List<d> opg = null;
    private boolean qoo = true;
    boolean qor;
    and tfo = new and();
    boolean tkA = false;
    private g.b tkx;
    c tky;
    b tkz;

    public interface b {
        void cVN();

        void cVP();

        void cVQ();

        void cVR();

        void cWF();
    }

    public interface c {
        void a(boolean z, d dVar, int i2);
    }

    public f(Context context, List<d> list, g.b bVar, Runnable runnable) {
        AppMethodBeat.i(107410);
        this.opg = list;
        this.qoo = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
        this.mContext = context;
        this.tkx = bVar;
        this.dLr = runnable;
        c.a aVar = new c.a();
        aVar.jbi = 1;
        aVar.jby = true;
        aVar.hZA = com.tencent.mm.cb.a.jn(context) / 4;
        aVar.hZz = com.tencent.mm.cb.a.jn(context) / 4;
        aVar.jbt = R.color.a3k;
        this.gzE = aVar.bdv();
        AppMethodBeat.o(107410);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(107411);
        int i3 = If(i2).type;
        AppMethodBeat.o(107411);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(107412);
        if (i2 == Integer.MAX_VALUE) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a77, viewGroup, false));
            AppMethodBeat.o(107412);
            return aVar;
        }
        e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a78, viewGroup, false));
        AppMethodBeat.o(107412);
        return eVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2, List list) {
        AppMethodBeat.i(107413);
        if (list == null || list.size() <= 0 || !(vVar instanceof e)) {
            super.a(vVar, i2, list);
            AppMethodBeat.o(107413);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((e) vVar).checkBox.setChecked(false);
            ((e) vVar).checkBox.setVisibility(0);
            ((e) vVar).tkM.setVisibility(0);
            AppMethodBeat.o(107413);
        } else {
            ((e) vVar).checkBox.setChecked(false);
            ((e) vVar).checkBox.setVisibility(8);
            ((e) vVar).tkM.setVisibility(8);
            AppMethodBeat.o(107413);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0177  */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final android.support.v7.widget.RecyclerView.v r11, int r12) {
        /*
        // Method dump skipped, instructions count: 423
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.gallery.f.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    public final String Cc(long j2) {
        AppMethodBeat.i(107415);
        String a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(j2), this.mContext);
        AppMethodBeat.o(107415);
        return a2;
    }

    private static long Cd(long j2) {
        AppMethodBeat.i(107416);
        long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(j2));
        AppMethodBeat.o(107416);
        return b2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(107417);
        int size = this.opg.size();
        AppMethodBeat.o(107417);
        return size;
    }

    public final d If(int i2) {
        AppMethodBeat.i(107418);
        if (i2 < 0) {
            AppMethodBeat.o(107418);
            return null;
        }
        d dVar = this.opg.get(i2);
        AppMethodBeat.o(107418);
        return dVar;
    }

    public class e extends RecyclerView.v {
        CheckBox checkBox;
        TextView qog;
        View.OnLongClickListener tib = new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(107407);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (f.this.tkA) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(107407);
                    return false;
                }
                if (view.getTag(R.id.iu_) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.iu_);
                    t(view, iArr[0], iArr[1]);
                } else {
                    t(view, 0, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(107407);
                return true;
            }

            private void t(View view, int i2, int i3) {
                AppMethodBeat.i(107408);
                final int intValue = ((Integer) view.getTag(R.id.cc0)).intValue();
                final d If = f.this.If(intValue);
                if (If == null) {
                    AppMethodBeat.o(107408);
                    return;
                }
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(f.this.mContext);
                e.this.tkK.setVisibility(0);
                aVar.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass1 */

                    public final void onDismiss() {
                        AppMethodBeat.i(107403);
                        if (e.this.tkK != null && !f.this.tkA) {
                            e.this.tkK.setVisibility(8);
                        }
                        AppMethodBeat.o(107403);
                    }
                };
                aVar.a(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass2 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(107404);
                        String d2 = com.tencent.mm.plugin.fav.a.b.d(If.tkC.dLo);
                        boolean YS = s.YS(d2);
                        boolean isGif = ImgUtil.isGif(d2);
                        if (!If.tkD && YS && !isGif) {
                            contextMenu.add(0, 0, 0, f.this.mContext.getString(R.string.cc8));
                            contextMenu.add(0, 1, 0, f.this.mContext.getString(R.string.cau));
                            contextMenu.add(0, 2, 0, f.this.mContext.getString(R.string.cc1));
                        } else if (!If.tkD || !YS || isGif) {
                            Log.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", Boolean.valueOf(If.tkD), Boolean.valueOf(YS), Boolean.valueOf(isGif));
                        } else {
                            contextMenu.add(0, 0, 0, f.this.mContext.getString(R.string.cc8));
                            contextMenu.add(0, 2, 0, f.this.mContext.getString(R.string.gav));
                        }
                        if (YS) {
                            com.tencent.mm.plugin.fav.a.g gVar = If.tkC.qNT;
                            if (gVar != null && (gVar.field_type == 18 || gVar.field_type == 14)) {
                                contextMenu.add(0, 4, 0, f.this.mContext.getString(R.string.c_q));
                            }
                            contextMenu.add(0, 5, 0, R.string.c94);
                        }
                        AppMethodBeat.o(107404);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(107406);
                        String d2 = com.tencent.mm.plugin.fav.a.b.d(If.tkC.dLo);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(If.tkC);
                                f.this.tkx.dM(arrayList);
                                AppMethodBeat.o(107406);
                                return;
                            case 1:
                                h.w(If.tkC.qNT.field_localId, 0);
                                com.tencent.mm.plugin.fav.a.b.b(d2, f.this.mContext);
                                if (f.this.tkz != null) {
                                    f.this.tkz.cVR();
                                    AppMethodBeat.o(107406);
                                    return;
                                }
                                break;
                            case 2:
                                if (f.this.tkz != null) {
                                    f.this.tkz.cVP();
                                }
                                if (Util.isNullOrNil(d2)) {
                                    Log.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                                    AppMethodBeat.o(107406);
                                    return;
                                } else if (!If.tkD) {
                                    p.a(f.this.mContext, d2, new p.a() {
                                        /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass3.AnonymousClass1 */

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bP(String str, String str2) {
                                            AppMethodBeat.i(235368);
                                            Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.bjr, AndroidMediaUtil.getToastSysCameraPath()), 1).show();
                                            AppMethodBeat.o(235368);
                                        }

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bQ(String str, String str2) {
                                            AppMethodBeat.i(235369);
                                            Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.cc0), 1).show();
                                            AppMethodBeat.o(235369);
                                        }
                                    });
                                    AppMethodBeat.o(107406);
                                    return;
                                } else {
                                    p.b(f.this.mContext, d2, new p.a() {
                                        /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass3.AnonymousClass2 */

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bP(String str, String str2) {
                                            AppMethodBeat.i(235370);
                                            Log.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", str, str2);
                                            Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                                            AppMethodBeat.o(235370);
                                        }

                                        @Override // com.tencent.mm.platformtools.p.a
                                        public final void bQ(String str, String str2) {
                                            AppMethodBeat.i(235371);
                                            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", str, str2);
                                            Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.hwt), 1).show();
                                            AppMethodBeat.o(235371);
                                        }
                                    });
                                    AppMethodBeat.o(107406);
                                    return;
                                }
                            case 4:
                                f.a(f.this, intValue, If);
                                AppMethodBeat.o(107406);
                                return;
                            case 5:
                                com.tencent.mm.plugin.fav.a.g gVar = If.tkC.qNT;
                                if (gVar == null || !(gVar.field_type == 18 || gVar.field_type == 14)) {
                                    com.tencent.mm.plugin.fav.a.b.a(gVar, f.this.dLr);
                                    if (f.this.tkz != null) {
                                        f.this.tkz.cWF();
                                        break;
                                    }
                                } else {
                                    f.a aVar = new f.a(f.this.mContext);
                                    aVar.bow(f.this.mContext.getString(R.string.c97));
                                    aVar.boB(f.this.mContext.getString(R.string.c92));
                                    aVar.boA(f.this.mContext.getString(R.string.c_q));
                                    aVar.a(new f.c() {
                                        /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass3.AnonymousClass3 */

                                        @Override // com.tencent.mm.ui.widget.a.f.c
                                        public final void e(boolean z, String str) {
                                        }
                                    }, new f.c() {
                                        /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass4.AnonymousClass3.AnonymousClass4 */

                                        @Override // com.tencent.mm.ui.widget.a.f.c
                                        public final void e(boolean z, String str) {
                                            AppMethodBeat.i(235372);
                                            f.a(f.this, intValue, If);
                                            AppMethodBeat.o(235372);
                                        }
                                    });
                                    aVar.show();
                                    AppMethodBeat.o(107406);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.o(107406);
                    }
                }, i2, i3);
                AppMethodBeat.o(107408);
            }
        };
        ImageView tkI;
        View tkJ;
        ImageView tkK;
        View tkL;
        View tkM;

        public e(View view) {
            super(view);
            AppMethodBeat.i(107409);
            this.tkI = (ImageView) view.findViewById(R.id.dl0);
            this.tkJ = view.findViewById(R.id.j6s);
            this.tkL = view.findViewById(R.id.hry);
            this.qog = (TextView) view.findViewById(R.id.j6p);
            this.tkK = (ImageView) view.findViewById(R.id.dl3);
            this.checkBox = (CheckBox) view.findViewById(R.id.fbe);
            this.tkM = view.findViewById(R.id.fbf);
            this.tkM.setVisibility(8);
            this.checkBox.setVisibility(8);
            this.tkJ.setVisibility(8);
            this.qog.setVisibility(8);
            this.tkL.setVisibility(8);
            this.tkI.setOnTouchListener(new View.OnTouchListener(f.this) {
                /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(107400);
                    if (motionEvent.getAction() == 0) {
                        view.setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    }
                    AppMethodBeat.o(107400);
                    return false;
                }
            });
            this.tkI.setOnClickListener(new View.OnClickListener(f.this) {
                /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107401);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Object tag = view.getTag(R.id.cc0);
                    if (tag == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107401);
                        return;
                    }
                    d If = f.this.If(((Integer) tag).intValue());
                    if (If == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107401);
                        return;
                    }
                    f.a(f.this, If);
                    if (f.this.tkz != null) {
                        b bVar2 = f.this.tkz;
                        ((Integer) view.getTag(R.id.cc0)).intValue();
                        bVar2.cVN();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107401);
                }
            });
            this.tkI.setOnLongClickListener(this.tib);
            this.tkM.setOnClickListener(new View.OnClickListener(f.this) {
                /* class com.tencent.mm.plugin.fav.ui.gallery.f.e.AnonymousClass3 */

                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(107402);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!e.this.checkBox.isChecked()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (e.a.cWN().tkt.size() < 9) {
                        e.this.checkBox.setChecked(z);
                        if (!z) {
                            e.this.tkK.setVisibility(8);
                        } else {
                            e.this.tkK.setVisibility(0);
                        }
                    } else if (!z) {
                        e.this.checkBox.setChecked(false);
                    }
                    if (f.this.tky != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        f.this.tky.a(z, f.this.If(intValue), intValue);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107402);
                }
            });
            AppMethodBeat.o(107409);
        }
    }

    public class a extends RecyclerView.v {
        TextView jUO;
        ProgressBar progressBar;

        public a(View view) {
            super(view);
            AppMethodBeat.i(107397);
            this.jUO = (TextView) view.findViewById(R.id.bkk);
            this.progressBar = (ProgressBar) view.findViewById(R.id.ep4);
            AppMethodBeat.o(107397);
        }
    }

    public static class d {
        public String imagePath;
        public long timeStamp;
        public d tkC;
        boolean tkD;
        boolean tkE;
        public a tkF = new a();
        public int type = 0;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(107398);
            if (this.tkC == null || !(obj instanceof d) || obj == null) {
                boolean equals = super.equals(obj);
                AppMethodBeat.o(107398);
                return equals;
            }
            boolean equals2 = this.tkC.dLo.dLl.equals(((d) obj).dLo.dLl);
            AppMethodBeat.o(107398);
            return equals2;
        }

        class a {
            public String tkG;

            a() {
            }
        }

        public d(d dVar) {
            String a2;
            AppMethodBeat.i(107399);
            this.tkC = dVar;
            if (dVar.cWK()) {
                a2 = dVar.dLo.dFN;
            } else if (dVar.cWJ() || dVar.cWL()) {
                a2 = com.tencent.mm.plugin.fav.a.b.a(dVar.dLo);
            } else {
                a2 = com.tencent.mm.plugin.fav.a.b.d(dVar.dLo);
                if (!new com.tencent.mm.vfs.o(a2).exists()) {
                    a2 = com.tencent.mm.plugin.fav.a.b.a(dVar.dLo);
                }
            }
            this.imagePath = a2;
            this.timeStamp = dVar.qNT.field_updateTime;
            if (dVar.cWJ() || dVar.cWL()) {
                this.tkD = true;
                this.tkF.tkG = Util.formatSecToMin(dVar.dLo.duration);
            }
            if (dVar.cWK()) {
                this.tkE = true;
            }
            AppMethodBeat.o(107399);
        }
    }

    static /* synthetic */ void a(f fVar, d dVar) {
        AppMethodBeat.i(164106);
        Intent intent = new Intent();
        if (dVar == null) {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
            AppMethodBeat.o(164106);
            return;
        }
        d dVar2 = dVar.tkC;
        if (dVar2 == null) {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
            AppMethodBeat.o(164106);
        } else if (dVar2.cWK()) {
            aml aml = dVar2.dLo;
            if (aml == null || aml.Lwh == null || aml.Lwh.Lxi == null) {
                Log.w("MicroMsg.MediaHistoryGalleryAdapter", "enterGallery favMpMsgItem is null");
                AppMethodBeat.o(164106);
                return;
            }
            com.tencent.mm.plugin.fav.ui.d.s.a(fVar.mContext, aml.Lwh.Lxi, aml, false);
            AppMethodBeat.o(164106);
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (d dVar3 : fVar.opg) {
                long j2 = dVar3.tkC.qNT.field_localId;
                if (!arrayList.contains(Long.valueOf(j2))) {
                    arrayList.add(Long.valueOf(j2));
                    if (j2 == dVar.tkC.qNT.field_localId) {
                        i2 = arrayList.size() - 1;
                    }
                }
                i2 = i2;
            }
            long[] jArr = new long[arrayList.size()];
            int i3 = i2 - 20 > 0 ? i2 - 20 : 0;
            int size = i2 + 20 < arrayList.size() ? i2 + 20 : arrayList.size();
            for (int i4 = i3; i4 < size; i4++) {
                jArr[i4] = ((Long) arrayList.get(i4)).longValue();
            }
            intent.addFlags(536870912);
            intent.putExtra("KEY_MEDIA_FAVID_LIST", jArr).putExtra("key_detail_info_id", dVar2.qNT.field_localId).putExtra("key_detail_data_id", dVar2.dLo.dLl);
            intent.putExtra("key_detail_fav_scene", fVar.tfo.scene);
            intent.putExtra("key_detail_fav_sub_scene", fVar.tfo.pHw);
            intent.putExtra("key_detail_fav_index", 0);
            intent.putExtra("key_detail_fav_query", fVar.tfo.query);
            intent.putExtra("key_detail_fav_sessionid", fVar.tfo.sessionId);
            intent.putExtra("key_detail_fav_tags", fVar.tfo.tay);
            com.tencent.mm.plugin.fav.a.b.b(fVar.mContext, ".ui.gallery.FavMediaGalleryUI", intent);
            ((Activity) fVar.mContext).overridePendingTransition(0, 0);
            AppMethodBeat.o(164106);
        }
    }

    static /* synthetic */ void a(f fVar, int i2, d dVar) {
        AppMethodBeat.i(235373);
        if (fVar.tkz != null) {
            fVar.tkz.cVQ();
        }
        fVar.tfo.index = fVar.getItemCount() - i2;
        dVar.tkC.qNT.taf = dVar.tkC.dLo.dLl;
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(fVar.mContext, dVar.tkC.qNT, fVar.tfo);
        AppMethodBeat.o(235373);
    }
}
