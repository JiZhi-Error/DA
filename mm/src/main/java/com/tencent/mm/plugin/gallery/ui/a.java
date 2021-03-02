package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends RecyclerView.a<RecyclerView.v> {
    int kyt = 10;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.gallery.ui.a.AnonymousClass3 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(111389);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Object tag = view.getTag(R.id.e3d);
            int intValue = tag instanceof Integer ? ((Integer) tag).intValue() : -1;
            Object tag2 = view.getTag(R.id.e42);
            if (tag2 instanceof Integer) {
                i2 = ((Integer) tag2).intValue();
            } else {
                i2 = -1;
            }
            if (!(intValue == -1 || i2 == -1 || a.this.xnw == null)) {
                a.this.xnw.a(intValue, view, i2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111389);
        }
    };
    private SimpleDateFormat qDM = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm, Locale.getDefault());
    int xjo;
    int xnn = 9;
    ArrayList<GalleryItem.MediaItem> xno = new ArrayList<>();
    ArrayList<GalleryItem.MediaItem> xnp = new ArrayList<>();
    private e xnq;
    String xnr;
    LinkedList<d> xns = new LinkedList<>();
    boolean xnt = false;
    private View.OnLongClickListener xnu = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.gallery.ui.a.AnonymousClass1 */

        public final boolean onLongClick(View view) {
            GalleryItem.MediaItem NK;
            AppMethodBeat.i(111387);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Object tag = view.getTag(R.id.e3d);
            if ((tag instanceof Integer) && (NK = a.this.NK(((Integer) tag).intValue())) != null) {
                ClipboardHelper.setText(a.this.mContext, "media info", NK.toString());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(111387);
            return true;
        }
    };
    private View.OnClickListener xnv = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.gallery.ui.a.AnonymousClass2 */

        public final void onClick(final View view) {
            int i2;
            boolean z;
            AppMethodBeat.i(111388);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Object tag = view.getTag(R.id.e3d);
            if (!(tag instanceof Integer)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
            }
            int intValue = ((Integer) tag).intValue();
            GalleryItem.MediaItem NK = a.this.NK(intValue);
            if (NK == null || Util.isNullOrNil(NK.xiW)) {
                Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
                a.this.ci(intValue);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
            }
            Log.i("MicroMsg.AlbumAdapter", "click image path:" + NK.xiW);
            if (a.this.xnp.contains(NK)) {
                a.this.xnp.indexOf(NK);
                a.this.i(NK);
                z = false;
                i2 = 1;
            } else if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 3 && NK.mMimeType.equalsIgnoreCase("image/gif") && !((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amz(NK.xiW)) {
                com.tencent.mm.plugin.gallery.a.d.bw(13459, s.boW(NK.xiW) + ",1,,0");
                h.cD(a.this.mContext, a.this.mContext.getString(R.string.dmp));
                a.this.ci(intValue);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
            } else if (a.this.xnt && com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 16 && ((a.this.xjo == 2 || a.this.xjo == 3) && a.this.xnp.size() > 0 && ((GalleryItem.MediaItem) a.this.xnp.get(0)).getType() != NK.getType())) {
                h.cD(a.this.mContext, com.tencent.mm.cb.a.aI(a.this.mContext, R.string.dm0));
                a.this.ci(intValue);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
            } else if (Util.isNullOrNil(a.this.xnr) || !a.this.xnr.equals("album_business_byp") || !NK.mMimeType.equalsIgnoreCase("image/gif") || ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amA(NK.xiW)) {
                if ((a.this.xjo == 2 || a.this.xjo == 3) && (NK instanceof GalleryItem.VideoMediaItem)) {
                    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25) {
                        long dRP = (long) a.dRP();
                        long dRQ = (long) a.dRQ();
                        if (((GalleryItem.VideoMediaItem) NK).jkS < com.tencent.mm.modelcontrol.e.baZ().bbf().minDuration * 1000) {
                            h.a(a.this.mContext, a.this.mContext.getResources().getString(R.string.dnb, Integer.valueOf(com.tencent.mm.modelcontrol.e.baZ().bbf().minDuration)), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.gallery.ui.a.AnonymousClass2.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(164790);
                                    if (view instanceof MMNumberCheckbox) {
                                        ((MMNumberCheckbox) view).setChecked(false);
                                    }
                                    AppMethodBeat.o(164790);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(111388);
                            return;
                        } else if (((long) ((GalleryItem.VideoMediaItem) NK).jkS) > dRP * 1000) {
                            h.a(a.this.mContext, a.this.mContext.getResources().getString(R.string.dnc, Long.valueOf(dRQ)), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.gallery.ui.a.AnonymousClass2.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(164791);
                                    if (view instanceof MMNumberCheckbox) {
                                        ((MMNumberCheckbox) view).setChecked(false);
                                    }
                                    AppMethodBeat.o(164791);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(111388);
                            return;
                        }
                    }
                    if (!Util.isNullOrNil(a.this.xnr) && a.this.xnr.equals("album_business_bubble_media_by_coordinate") && ((GalleryItem.VideoMediaItem) NK).jkS >= (a.this.kyt * 1000) + 500) {
                        h.cD(a.this.mContext, a.this.mContext.getResources().getString(R.string.dnc, Integer.valueOf(a.this.kyt)));
                        a.this.ci(intValue);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(111388);
                        return;
                    }
                }
                if (a.this.xnp.size() < a.this.xnn) {
                    a.this.xnp.add(NK);
                    a.this.xnp.size();
                    z = false;
                    i2 = 0;
                } else {
                    i2 = 0;
                    z = true;
                }
                a.this.ci(intValue);
            } else {
                h.cD(a.this.mContext, a.this.mContext.getString(R.string.dlx));
                a.this.ci(intValue);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
            }
            if (!z) {
                if (a.this.xnq != null) {
                    a.this.xnq.ah(a.this.xnp.size(), intValue, i2);
                }
            } else if (a.this.xjo == 1) {
                h.cD(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.o, a.this.xnn, Integer.valueOf(a.this.xnn)));
            } else if (a.this.xjo == 2) {
                h.cD(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.q, a.this.xnn, Integer.valueOf(a.this.xnn)));
            } else {
                h.cD(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.p, a.this.xnn, Integer.valueOf(a.this.xnn)));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
        }
    };
    f xnw;

    public interface e {
        void ah(int i2, int i3, int i4);
    }

    /* access modifiers changed from: package-private */
    public interface f {
        void a(int i2, View view, int i3);
    }

    public a(Context context, e eVar) {
        AppMethodBeat.i(111407);
        this.mContext = context;
        this.xnq = eVar;
        for (int i2 = 0; i2 < 32; i2++) {
            this.xno.add(new GalleryItem.ImageMediaItem());
        }
        this.atj.notifyChanged();
        AppMethodBeat.o(111407);
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar) {
        AppMethodBeat.i(111408);
        if (dVar == null) {
            Log.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            AppMethodBeat.o(111408);
            return;
        }
        this.xns.remove(dVar);
        this.xns.add(dVar);
        AppMethodBeat.o(111408);
    }

    public final void setSelectLimitCount(int i2) {
        this.xnn = i2;
    }

    public final void setQueryType(int i2) {
        this.xjo = i2;
    }

    public final void aN(LinkedList<GalleryItem.MediaItem> linkedList) {
        AppMethodBeat.i(111409);
        int itemCount = getItemCount() - this.xns.size();
        int size = linkedList.size();
        if (itemCount < size) {
            this.xno.addAll(linkedList.subList(itemCount, size));
            as(itemCount + this.xns.size(), getItemCount());
        }
        AppMethodBeat.o(111409);
    }

    public final void clear() {
        AppMethodBeat.i(261886);
        this.xno.clear();
        AppMethodBeat.o(261886);
    }

    public final ArrayList<String> dRL() {
        AppMethodBeat.i(111410);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<GalleryItem.MediaItem> it = this.xnp.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().xiW);
        }
        AppMethodBeat.o(111410);
        return arrayList;
    }

    public final ArrayList<GalleryItem.MediaItem> dRM() {
        return this.xnp;
    }

    /* access modifiers changed from: package-private */
    public final void eX(List<GalleryItem.MediaItem> list) {
        AppMethodBeat.i(111411);
        this.xnp.clear();
        this.xnp.addAll(list);
        AppMethodBeat.o(111411);
    }

    public final void aq(ArrayList<String> arrayList) {
        AppMethodBeat.i(111412);
        Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", this.xnp);
        this.xnp.clear();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(0, 0, next, "", "");
                if (com.tencent.mm.plugin.gallery.model.e.dQM() != null) {
                    int indexOf = com.tencent.mm.plugin.gallery.model.e.dQM().indexOf(a2);
                    if (indexOf >= 0) {
                        this.xnp.add(com.tencent.mm.plugin.gallery.model.e.dQM().get(indexOf));
                    } else {
                        Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                        if (next.toLowerCase().endsWith("mp4")) {
                            this.xnp.add(GalleryItem.MediaItem.a(2, 0, next, "", ""));
                        } else {
                            this.xnp.add(GalleryItem.MediaItem.a(1, 0, next, "", ""));
                        }
                    }
                }
            }
        }
        Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", this.xnp);
        AppMethodBeat.o(111412);
    }

    public final ArrayList<GalleryItem.MediaItem> dRN() {
        return this.xno;
    }

    public final ArrayList<GalleryItem.MediaItem> NJ(int i2) {
        AppMethodBeat.i(111413);
        ArrayList<GalleryItem.MediaItem> arrayList = new ArrayList<>();
        Iterator<GalleryItem.MediaItem> it = this.xno.iterator();
        while (it.hasNext()) {
            GalleryItem.MediaItem next = it.next();
            if (next.getType() == i2) {
                arrayList.add(next);
            }
        }
        AppMethodBeat.o(111413);
        return arrayList;
    }

    public final int dRO() {
        AppMethodBeat.i(164794);
        int size = this.xnp.size();
        AppMethodBeat.o(164794);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(111414);
        int size = this.xns.size() + this.xno.size();
        AppMethodBeat.o(111414);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(111415);
        if (i2 < this.xns.size()) {
            int i3 = this.xns.get(i2).xnH;
            AppMethodBeat.o(111415);
            return i3;
        }
        AppMethodBeat.o(111415);
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(111416);
        switch (i2) {
            case 0:
                c cVar = new c(LayoutInflater.from(this.mContext).inflate(R.layout.lw, viewGroup, false));
                AppMethodBeat.o(111416);
                return cVar;
            default:
                C1390a aVar = new C1390a(LayoutInflater.from(this.mContext).inflate(R.layout.bok, viewGroup, false));
                AppMethodBeat.o(111416);
                return aVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        String concat;
        AppMethodBeat.i(111417);
        if (vVar instanceof c) {
            vVar.aus.setTag(R.id.e3d, Integer.valueOf(i2));
            vVar.aus.setTag(R.id.e42, 0);
            vVar.aus.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.o(111417);
            return;
        }
        if (vVar instanceof C1390a) {
            vVar.aus.setTag(R.id.e3d, Integer.valueOf(i2));
            vVar.aus.setTag(R.id.e42, 1);
            vVar.aus.setOnClickListener(this.mOnClickListener);
            GalleryItem.MediaItem NK = NK(i2);
            if (NK == null) {
                Log.e("MicroMsg.AlbumAdapter", "get item failed");
                AppMethodBeat.o(111417);
                return;
            }
            String aQn = NK.aQn();
            String str = NK.xiW;
            if (!Util.isNullOrNil(aQn) || !Util.isNullOrNil(str)) {
                C1390a aVar = (C1390a) vVar;
                aVar.xnC.setTag(R.id.e3d, Integer.valueOf(i2));
                aVar.xnC.setOnClickListener(this.xnv);
                aVar.xnA.setVisibility(0);
                aVar.xnB.setVisibility(0);
                aVar.xnD.setVisibility(0);
                if (2 == NK.getType()) {
                    aVar.xnA.setImageResource(R.raw.video_icon_in_gird);
                    g.a(aVar.xnB, (GalleryItem.VideoMediaItem) NK);
                } else if (NK.mMimeType.equalsIgnoreCase("edit")) {
                    aVar.xnA.setImageResource(R.raw.photo_edit_mark);
                    aVar.xnB.setVisibility(4);
                } else if (NK.mMimeType.equalsIgnoreCase("image/gif")) {
                    aVar.xnA.setImageResource(R.drawable.c_j);
                    aVar.xnB.setVisibility(4);
                } else {
                    aVar.xnA.setVisibility(4);
                    aVar.xnB.setVisibility(4);
                    aVar.xnD.setVisibility(4);
                }
                String str2 = ((i2 - this.xns.size()) + 1) + ", " + this.qDM.format(new Date(NK.xja));
                if (2 == NK.getType()) {
                    concat = "视频 ".concat(String.valueOf(str2));
                } else {
                    concat = "图片".concat(String.valueOf(str2));
                }
                aVar.xdY.setContentDescription(concat);
                Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", aQn, str, concat);
                h.a(aVar.xdY, NK.getType(), aQn, str, NK.xiZ, NK.xja);
                aVar.xnC.setVisibility(0);
                int i3 = com.tencent.mm.plugin.gallery.model.e.dQK().mcq;
                if (i3 == 0 || 5 == i3 || 10 == i3 || 11 == i3 || 24 == i3 || i3 == 27) {
                    aVar.xnC.setVisibility(4);
                } else if (15 == i3) {
                    aVar.xnC.setBackgroundResource(R.drawable.a90);
                } else if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25) {
                    aVar.xnC.setBackgroundResource(R.drawable.a8z);
                }
                if (this.xnt) {
                    if (16 == i3 && ((NK.getType() == 2 || NK.getType() == 3) && this.xnn > 1)) {
                        aVar.xnC.setVisibility(0);
                        if (this.xnp.contains(NK)) {
                            aVar.xnC.setCheckedNumber(this.xnp.indexOf(NK) + 1);
                            aVar.xnz.setBackgroundResource(R.color.ad);
                        } else {
                            aVar.xnC.setChecked(false);
                            aVar.xnz.setBackgroundResource(R.color.vt);
                        }
                    } else if (NK.getType() == 2) {
                        aVar.xnC.setVisibility(4);
                    } else if (this.xnp.contains(NK)) {
                        aVar.xnC.setCheckedNumber(this.xnp.indexOf(NK) + 1);
                        aVar.xnz.setBackgroundResource(R.color.ad);
                    } else {
                        aVar.xnC.setChecked(false);
                        aVar.xnz.setBackgroundResource(R.color.vt);
                    }
                } else if (this.xnp.contains(NK)) {
                    aVar.xnC.setCheckedNumber(this.xnp.indexOf(NK) + 1);
                    aVar.xnz.setBackgroundResource(R.color.ad);
                } else {
                    aVar.xnC.setChecked(false);
                    aVar.xnz.setBackgroundResource(R.color.vt);
                }
                if (aVar.xnC.getVisibility() == 0) {
                    C1390a.a(aVar, aVar.xnC);
                } else {
                    C1390a.el(aVar.xnC);
                }
                aVar.aus.setOnLongClickListener(this.xnu);
            } else {
                Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", Integer.valueOf(i2));
                AppMethodBeat.o(111417);
                return;
            }
        }
        AppMethodBeat.o(111417);
    }

    public final GalleryItem.MediaItem NK(int i2) {
        AppMethodBeat.i(111418);
        if (i2 < this.xns.size()) {
            Log.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", Integer.valueOf(i2));
            AppMethodBeat.o(111418);
            return null;
        }
        int size = i2 - this.xns.size();
        if (size >= this.xno.size()) {
            Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", Integer.valueOf(this.xno.size()), Integer.valueOf(size));
            AppMethodBeat.o(111418);
            return null;
        }
        GalleryItem.MediaItem mediaItem = this.xno.get(size);
        AppMethodBeat.o(111418);
        return mediaItem;
    }

    /* access modifiers changed from: package-private */
    public final String NL(int i2) {
        AppMethodBeat.i(111419);
        if (i2 < this.xns.size()) {
            Log.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", Integer.valueOf(i2));
            i2 = this.xns.size();
        }
        GalleryItem.MediaItem NK = NK(i2);
        if (NK == null) {
            AppMethodBeat.o(111419);
            return "";
        } else if (!Util.isNullOrNil(NK.xjc)) {
            String str = NK.xjc;
            AppMethodBeat.o(111419);
            return str;
        } else {
            String a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(NK.xja), this.mContext);
            AppMethodBeat.o(111419);
            return a2;
        }
    }

    public static class g implements Runnable {
        private static HashMap<TextView, g> xnK = new HashMap<>();
        private boolean ifz;
        private WeakReference<TextView> sTx;
        private GalleryItem.VideoMediaItem xnI;
        private AbstractC1392a xnJ;

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.gallery.ui.a$g$a  reason: collision with other inner class name */
        public interface AbstractC1392a {
            void a(g gVar, int i2);
        }

        static /* synthetic */ void k(TextView textView, int i2) {
            AppMethodBeat.i(257734);
            j(textView, i2);
            AppMethodBeat.o(257734);
        }

        private g(TextView textView, GalleryItem.VideoMediaItem videoMediaItem, AbstractC1392a aVar) {
            AppMethodBeat.i(111397);
            this.sTx = new WeakReference<>(textView);
            this.xnI = videoMediaItem;
            this.xnJ = aVar;
            AppMethodBeat.o(111397);
        }

        static {
            AppMethodBeat.i(111406);
            AppMethodBeat.o(111406);
        }

        public static void dRR() {
            AppMethodBeat.i(111398);
            xnK.clear();
            AppMethodBeat.o(111398);
        }

        public static void a(TextView textView, GalleryItem.VideoMediaItem videoMediaItem) {
            g gVar;
            AppMethodBeat.i(111399);
            if (textView == null || videoMediaItem == null) {
                Log.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                AppMethodBeat.o(111399);
                return;
            }
            if (xnK.containsKey(textView) && (gVar = xnK.get(textView)) != null) {
                if (gVar.xnI.equals(videoMediaItem)) {
                    AppMethodBeat.o(111399);
                    return;
                } else if (textView.equals(gVar.sTx.get())) {
                    gVar.sTx = new WeakReference<>(null);
                    gVar.ifz = true;
                }
            }
            if (videoMediaItem.jkS >= 0) {
                Log.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", Integer.valueOf(videoMediaItem.jkS), videoMediaItem);
                j(textView, videoMediaItem.jkS);
                xnK.remove(textView);
                AppMethodBeat.o(111399);
                return;
            }
            textView.setText("");
            g gVar2 = new g(textView, videoMediaItem, new AbstractC1392a() {
                /* class com.tencent.mm.plugin.gallery.ui.a.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.gallery.ui.a.g.AbstractC1392a
                public final void a(g gVar, int i2) {
                    AppMethodBeat.i(111396);
                    if (gVar == null || gVar.sTx == null) {
                        AppMethodBeat.o(111396);
                        return;
                    }
                    TextView textView = (TextView) gVar.sTx.get();
                    if (textView == null) {
                        AppMethodBeat.o(111396);
                        return;
                    }
                    g.k(textView, i2);
                    g.xnK.remove(textView);
                    AppMethodBeat.o(111396);
                }
            });
            com.tencent.mm.plugin.gallery.model.e.dQL().aq(gVar2);
            xnK.put(textView, gVar2);
            AppMethodBeat.o(111399);
        }

        private static void j(TextView textView, int i2) {
            AppMethodBeat.i(111400);
            if (textView == null) {
                AppMethodBeat.o(111400);
            } else if (i2 < 0) {
                textView.setText("--:--");
                AppMethodBeat.o(111400);
            } else {
                int round = Math.round(((float) i2) / 1000.0f);
                String valueOf = String.valueOf(round % 60);
                if (valueOf.length() < 2) {
                    valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(valueOf));
                }
                textView.setText((round / 60) + ":" + valueOf);
                AppMethodBeat.o(111400);
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(111401);
            if (!(obj instanceof g)) {
                AppMethodBeat.o(111401);
                return false;
            }
            boolean equals = this.xnI.equals(((g) obj).xnI);
            AppMethodBeat.o(111401);
            return equals;
        }

        public final int hashCode() {
            AppMethodBeat.i(111402);
            int hashCode = this.xnI.hashCode();
            AppMethodBeat.o(111402);
            return hashCode;
        }

        public final void run() {
            AppMethodBeat.i(111404);
            if (this.ifz) {
                AppMethodBeat.o(111404);
                return;
            }
            if (ayX(this.xnI.aQn())) {
                dRS();
            } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_album_get_video_info, 0) == 1) {
                dRS();
            } else {
                long currentTicks = Util.currentTicks();
                com.tencent.mm.compatible.i.c cVar = new com.tencent.mm.compatible.i.c();
                String aQn = this.xnI.aQn();
                try {
                    cVar.setDataSource(aQn);
                    int trackCount = cVar.gLF.getTrackCount();
                    MediaFormat mediaFormat = null;
                    MediaFormat mediaFormat2 = null;
                    for (int i2 = 0; i2 < trackCount; i2++) {
                        MediaFormat trackFormat = cVar.getTrackFormat(i2);
                        if (trackFormat.containsKey("mime")) {
                            String string = trackFormat.getString("mime");
                            Log.d("MicroMsg.AlbumAdapter", "find video mime : %s", string);
                            if (string != null) {
                                if (string.startsWith("video/")) {
                                    if (mediaFormat == null) {
                                        mediaFormat = trackFormat;
                                    }
                                } else if (string.startsWith("audio/") && mediaFormat2 == null) {
                                    mediaFormat2 = trackFormat;
                                }
                                if (!(mediaFormat2 == null || mediaFormat == null)) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            Log.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
                        }
                    }
                    if (this.xnI != null) {
                        if (mediaFormat != null) {
                            this.xnI.jkS = !mediaFormat.containsKey("durationUs") ? 0 : (int) (mediaFormat.getLong("durationUs") / 1000);
                            this.xnI.videoHeight = !mediaFormat.containsKey("height") ? 0 : mediaFormat.getInteger("height");
                            this.xnI.videoWidth = !mediaFormat.containsKey("width") ? 0 : mediaFormat.getInteger("width");
                            this.xnI.jkQ = !mediaFormat.containsKey("mime") ? "" : mediaFormat.getString("mime");
                            this.xnI.videoBitRate = !mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                            this.xnI.videoIFrameInterval = !mediaFormat.containsKey("i-frame-interval") ? 0 : mediaFormat.getInteger("i-frame-interval");
                            this.xnI.videoFrameRate = !mediaFormat.containsKey("frame-rate") ? 0 : mediaFormat.getInteger("frame-rate");
                            this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(aQn);
                        }
                        if (mediaFormat2 != null) {
                            this.xnI.jkR = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                        }
                    }
                    Log.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", this.xnI);
                    Log.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", mediaFormat, aQn);
                    cVar.gLF.release();
                } catch (Exception e2) {
                    Log.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", aQn, e2.getMessage());
                    cVar.gLF.release();
                } catch (Throwable th) {
                    cVar.gLF.release();
                    AppMethodBeat.o(111404);
                    throw th;
                }
                Log.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            if (!this.ifz) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (this.xnJ != null) {
                        this.xnJ.a(this, this.xnI.jkS);
                    }
                    AppMethodBeat.o(111404);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.gallery.ui.a.g.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(111395);
                        if (g.this.xnJ != null) {
                            g.this.xnJ.a(g.this, g.this.xnI.jkS);
                        }
                        AppMethodBeat.o(111395);
                    }
                });
            }
            AppMethodBeat.o(111404);
        }

        private static boolean ayX(String str) {
            AppMethodBeat.i(173745);
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_album_device_configuration, "");
            if (TextUtils.isEmpty(a2)) {
                AppMethodBeat.o(173745);
                return false;
            }
            Log.i("MicroMsg.AlbumAdapter", "devices configuration: %s", a2);
            Log.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
            try {
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString("devices");
                int optInt = jSONObject.optInt("maxsize");
                JSONArray jSONArray = new JSONArray(optString);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (Build.MANUFACTURER.equalsIgnoreCase(optJSONObject.optString("brand")) && Build.MODEL.equalsIgnoreCase(optJSONObject.optString("model"))) {
                        long boW = s.boW(str);
                        if (optInt == 0 || boW <= ((long) (optInt * 1024 * 1024))) {
                            int optInt2 = optJSONObject.optInt("androidVersion");
                            if (-1 == optInt2) {
                                Log.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                                AppMethodBeat.o(173745);
                                return true;
                            } else if (Build.VERSION.SDK_INT == optInt2) {
                                Log.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                                AppMethodBeat.o(173745);
                                return true;
                            }
                        } else {
                            Log.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", Long.valueOf(boW), Integer.valueOf(optInt), str);
                            AppMethodBeat.o(173745);
                            return false;
                        }
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "parse json error", new Object[0]);
            }
            AppMethodBeat.o(173745);
            return false;
        }

        private void dRS() {
            AppMethodBeat.i(173746);
            if (this.xnI == null) {
                AppMethodBeat.o(173746);
                return;
            }
            long currentTicks = Util.currentTicks();
            try {
                String aQn = this.xnI.aQn();
                String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(aQn);
                Log.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", simpleMp4InfoVFS);
                JSONObject jSONObject = new JSONObject(simpleMp4InfoVFS);
                this.xnI.jkS = jSONObject.getInt("videoDuration");
                this.xnI.videoHeight = jSONObject.getInt("videoHeight");
                this.xnI.videoWidth = jSONObject.getInt("videoWidth");
                this.xnI.videoBitRate = jSONObject.getInt("videoBitrate");
                this.xnI.videoFrameRate = jSONObject.getInt("videoFPS");
                this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(aQn);
                this.xnI.videoIFrameInterval = 0;
                this.xnI.jkQ = com.tencent.mm.plugin.gallery.a.b.azg(jSONObject.getString("videoType"));
                this.xnI.jkR = com.tencent.mm.plugin.gallery.a.b.azg(jSONObject.getString("audioType"));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "loadItemFromSimpleMP4Info fail", new Object[0]);
            }
            Log.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", this.xnI);
            Log.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(173746);
        }
    }

    static class c extends RecyclerView.v {
        private TextView xnG;

        c(View view) {
            super(view);
            AppMethodBeat.i(111394);
            this.xnG = (TextView) view.findViewById(R.id.fc1);
            if (com.tencent.mm.plugin.gallery.model.e.dQK().xjo == 2 || com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 13) {
                this.xnG.setText(R.string.dna);
                AppMethodBeat.o(111394);
                return;
            }
            if (com.tencent.mm.plugin.gallery.model.e.dQK().xjo == 1) {
                this.xnG.setText(R.string.dn_);
            }
            AppMethodBeat.o(111394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$a  reason: collision with other inner class name */
    static class C1390a extends RecyclerView.v {
        ImageView xdY;
        ImageView xnA;
        TextView xnB;
        MMNumberCheckbox xnC;
        View xnD;
        ImageView xnz;

        C1390a(View view) {
            super(view);
            AppMethodBeat.i(111391);
            this.xdY = (ImageView) view.findViewById(R.id.fc1);
            this.xnz = (ImageView) view.findViewById(R.id.fbr);
            this.xnA = (ImageView) view.findViewById(R.id.izk);
            this.xnB = (TextView) view.findViewById(R.id.izl);
            this.xnC = (MMNumberCheckbox) view.findViewById(R.id.fbe);
            this.xnD = view.findViewById(R.id.izj);
            AppMethodBeat.o(111391);
        }

        static /* synthetic */ void a(C1390a aVar, final View view) {
            AppMethodBeat.i(111392);
            final View view2 = (View) view.getParent();
            view2.post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.ui.a.C1390a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(111390);
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.left -= com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 20);
                    rect.top -= com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 20);
                    rect.right += com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 20);
                    rect.bottom += com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 20);
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                    AppMethodBeat.o(111390);
                }
            });
            AppMethodBeat.o(111392);
        }

        static /* synthetic */ void el(View view) {
            AppMethodBeat.i(111393);
            ((View) view.getParent()).setTouchDelegate(null);
            AppMethodBeat.o(111393);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class d {
        int xnH;

        d() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends d {
        b() {
            this.xnH = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(111420);
        if (this.xnp.contains(mediaItem)) {
            ArrayList arrayList = new ArrayList();
            for (int indexOf = this.xnp.indexOf(mediaItem); indexOf < this.xnp.size(); indexOf++) {
                int indexOf2 = this.xno.indexOf(this.xnp.get(indexOf));
                if (indexOf2 != -1) {
                    arrayList.add(Integer.valueOf(indexOf2));
                }
            }
            this.xnp.remove(mediaItem);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ci(((Integer) it.next()).intValue() + this.xns.size());
            }
        }
        AppMethodBeat.o(111420);
    }

    /* access modifiers changed from: package-private */
    public final void a(android.support.v4.e.b<Integer> bVar) {
        AppMethodBeat.i(111421);
        for (int i2 = 0; i2 < this.xnp.size(); i2++) {
            int indexOf = this.xno.indexOf(this.xnp.get(i2));
            if (indexOf != -1) {
                bVar.add(Integer.valueOf(indexOf));
            }
        }
        Iterator<Integer> it = bVar.iterator();
        while (it.hasNext()) {
            ci(it.next().intValue() + this.xns.size());
        }
        AppMethodBeat.o(111421);
    }

    public final void aM(LinkedList<GalleryItem.MediaItem> linkedList) {
        AppMethodBeat.i(164792);
        this.xno.clear();
        this.xno.addAll(linkedList);
        this.atj.notifyChanged();
        AppMethodBeat.o(164792);
    }

    static /* synthetic */ int dRP() {
        AppMethodBeat.i(257736);
        int max = Math.max(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300), ((aj) com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().dDc());
        AppMethodBeat.o(257736);
        return max;
    }

    static /* synthetic */ int dRQ() {
        AppMethodBeat.i(257737);
        int max = Math.max(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300), ((aj) com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().dDc() - 1);
        AppMethodBeat.o(257737);
        return max;
    }
}
