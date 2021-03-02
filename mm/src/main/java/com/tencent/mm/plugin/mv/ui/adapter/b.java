package com.tencent.mm.plugin.mv.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005:;<=>B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0014\u0010\"\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u0006\u0010$\u001a\u00020 J\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010&\u001a\u00020\u0014J\u0010\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010(\u001a\u00020\u0014J\b\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0014J\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010-\u001a\u00020\u0014J\u0018\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0014H\u0017J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0014\u00105\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u0010\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\u0012J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u0014R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "headers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "maxDurationSec", "", "getMaxDurationSec", "()I", "maxDurationTip", "getMaxDurationTip", "mediaCount", "getMediaCount", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "videoMaxDurationMs", "videoMinDurationMs", "addHeader", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "addMediaItems", "mediaItems", "clear", "getAllMediaItem", "getHeaderCount", "getItem", "position", "getItemCount", "getItemViewType", "getItemWithOutAdjust", "getTypeRelatedMediaItems", "type", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeHeader", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setVideoDuration", "videoMinDuration", "AlbumViewHolder", "CameraHeaderViewHolder", "Companion", "OnItemClickListener", "SimpleVideoAnalysisTask", "plugin-mv_release"})
public final class b extends RecyclerView.a<RecyclerView.v> {
    public static final c ArM = new c((byte) 0);
    public ArrayList<GalleryItem.MediaItem> ArI = new ArrayList<>();
    public int ArJ = 10001;
    private int ArK = Integer.MAX_VALUE;
    public d ArL;
    private final Context mContext;
    private final View.OnClickListener mOnClickListener = new f(this);
    private final SimpleDateFormat qDM = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm, Locale.getDefault());
    public final LinkedList<c.AbstractC1550b> xns = new LinkedList<>();
    private final View.OnLongClickListener xnu = new g(this);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"})
    public interface d {
        void a(int i2, View view, int i3);
    }

    static {
        AppMethodBeat.i(256994);
        AppMethodBeat.o(256994);
    }

    public b(Context context) {
        p.h(context, "mContext");
        AppMethodBeat.i(256993);
        this.mContext = context;
        notifyDataSetChanged();
        AppMethodBeat.o(256993);
    }

    public final void aN(LinkedList<GalleryItem.MediaItem> linkedList) {
        AppMethodBeat.i(256987);
        p.h(linkedList, "mediaItems");
        int itemCount = getItemCount() - this.xns.size();
        int size = linkedList.size();
        if (itemCount < size) {
            this.ArI.addAll(linkedList.subList(itemCount, size));
            as(this.xns.size() + itemCount, getItemCount());
        }
        AppMethodBeat.o(256987);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(256988);
        int size = this.xns.size() + this.ArI.size();
        AppMethodBeat.o(256988);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(256989);
        if (i2 < this.xns.size()) {
            int i3 = this.xns.get(i2).xnH;
            AppMethodBeat.o(256989);
            return i3;
        }
        AppMethodBeat.o(256989);
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(256990);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bdp, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(mCon…           parent, false)");
                a aVar = new a(inflate);
                AppMethodBeat.o(256990);
                return aVar;
            case 2:
                View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.be8, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(mCon…           parent, false)");
                C1549b bVar = new C1549b(inflate2);
                AppMethodBeat.o(256990);
                return bVar;
            default:
                View inflate3 = LayoutInflater.from(this.mContext).inflate(R.layout.bdp, viewGroup, false);
                p.g(inflate3, "LayoutInflater.from(mCon…           parent, false)");
                a aVar2 = new a(inflate3);
                AppMethodBeat.o(256990);
                return aVar2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    @SuppressLint({"ResourceType"})
    public final void a(RecyclerView.v vVar, int i2) {
        String concat;
        e eVar;
        AppMethodBeat.i(256991);
        p.h(vVar, "holder");
        if (vVar instanceof C1549b) {
            vVar.aus.setTag(R.id.e3d, Integer.valueOf(i2));
            vVar.aus.setTag(R.id.e42, 2);
            vVar.aus.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.o(256991);
            return;
        }
        if (vVar instanceof a) {
            vVar.aus.setTag(R.id.e3d, Integer.valueOf(i2));
            vVar.aus.setTag(R.id.e42, 1);
            vVar.aus.setOnClickListener(this.mOnClickListener);
            GalleryItem.MediaItem NK = NK(i2);
            if (NK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
                AppMethodBeat.o(256991);
                throw tVar;
            }
            GalleryItem.VideoMediaItem videoMediaItem = (GalleryItem.VideoMediaItem) NK;
            if (videoMediaItem == null) {
                Log.e("Music.MusicMvAlbumVideoAdapter", "get item failed");
                AppMethodBeat.o(256991);
                return;
            }
            String aQn = videoMediaItem.aQn();
            p.g(aQn, "item.thumbPath");
            String dRh = videoMediaItem.dRh();
            p.g(dRh, "item.originalPath");
            if (!Util.isNullOrNil(aQn) || !Util.isNullOrNil(dRh)) {
                a aVar = (a) vVar;
                aVar.xnB.setVisibility(0);
                if (2 == videoMediaItem.getType()) {
                    e.a aVar2 = e.ArP;
                    TextView textView = aVar.xnB;
                    ImageView imageView = aVar.xnz;
                    int i3 = this.ArJ;
                    int i4 = this.ArK;
                    if (textView == null || imageView == null || videoMediaItem == null) {
                        Log.e("Music.MusicMvAlbumVideoAdapter", "Error input for duration fetcher");
                    } else {
                        if (e.xnK.containsKey(textView) && (eVar = (e) e.xnK.get(textView)) != null) {
                            if (!p.j(eVar.xnI, videoMediaItem)) {
                                WeakReference weakReference = eVar.sTx;
                                if (weakReference == null) {
                                    p.hyc();
                                }
                                if (p.j(textView, (TextView) weakReference.get())) {
                                    e.d(eVar);
                                    e.e(eVar);
                                    eVar.ifz = true;
                                }
                            }
                        }
                        if (videoMediaItem.jkS >= 0) {
                            Log.i("Music.MusicMvAlbumVideoAdapter", "Directly attach durationMs %d to tv, path %s", Integer.valueOf(videoMediaItem.jkS), videoMediaItem);
                            e.a.a(textView, imageView, videoMediaItem.jkS, i3, i4);
                            e.xnK.remove(textView);
                        } else {
                            textView.setText("");
                            e eVar2 = new e(textView, imageView, videoMediaItem, new e.a.C1551a(i3, i4), (byte) 0);
                            com.tencent.mm.plugin.gallery.model.e.dQL().aq(eVar2);
                            e.xnK.put(textView, eVar2);
                        }
                    }
                }
                String format = this.qDM.format(new Date(videoMediaItem.xja));
                p.g(format, "mDateFormat.format(Date(item.generateDate))");
                String str = (i2 + 1) + ", " + format;
                if (2 == videoMediaItem.getType()) {
                    concat = "视频 ".concat(String.valueOf(str));
                } else {
                    concat = "图片".concat(String.valueOf(str));
                }
                aVar.xdY.setContentDescription(concat);
                Log.d("Music.MusicMvAlbumVideoAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", aQn, dRh, concat);
                h.a(aVar.xdY, videoMediaItem.getType(), aQn, dRh, videoMediaItem.xiZ, videoMediaItem.xja);
                Log.d("Music.MusicMvAlbumVideoAdapter", "item path:" + videoMediaItem.xiW + ", width:" + videoMediaItem.videoWidth + ", height:" + videoMediaItem.videoHeight + ", durationMs:" + videoMediaItem.jkS + ", videoMinDurationMs:" + this.ArJ + ", videoMaxDurationMs:" + this.ArK);
                if (com.tencent.mm.plugin.mv.ui.a.e.Tm(videoMediaItem.jkS) < com.tencent.mm.plugin.mv.ui.a.e.Tl(this.ArJ) || com.tencent.mm.plugin.mv.ui.a.e.Tm(videoMediaItem.jkS) > com.tencent.mm.plugin.mv.ui.a.e.Tl(this.ArK)) {
                    aVar.xnz.setBackgroundColor(com.tencent.mm.cb.a.n(this.mContext, R.color.ad));
                } else {
                    aVar.xnz.setBackgroundResource(R.drawable.ali);
                }
                aVar.aus.setOnLongClickListener(this.xnu);
            } else {
                Log.e("Music.MusicMvAlbumVideoAdapter", "null or nil filepath, poi: %s.", Integer.valueOf(i2));
                AppMethodBeat.o(256991);
                return;
            }
        }
        AppMethodBeat.o(256991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "Landroid/view/View$OnLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
    public static final class g implements View.OnLongClickListener {
        final /* synthetic */ b ArT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(b bVar) {
            this.ArT = bVar;
        }

        public final boolean onLongClick(View view) {
            GalleryItem.MediaItem NK;
            AppMethodBeat.i(256986);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            p.h(view, "v");
            Object tag = view.getTag(R.id.e3d);
            p.g(tag, "v.getTag(R.id.item_position)");
            if ((tag instanceof Integer) && (NK = this.ArT.NK(((Number) tag).intValue())) != null) {
                ClipboardHelper.setText(this.ArT.mContext, "media info", NK.toString());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(256986);
            return true;
        }
    }

    public final GalleryItem.MediaItem NK(int i2) {
        AppMethodBeat.i(256992);
        if (i2 < this.xns.size()) {
            Log.i("Music.MusicMvAlbumVideoAdapter", "get header, pos[%d]", Integer.valueOf(i2));
            AppMethodBeat.o(256992);
            return null;
        }
        int size = i2 - this.xns.size();
        if (size >= this.ArI.size()) {
            Log.w("Music.MusicMvAlbumVideoAdapter", "get item error, media items size[%d], adjustPos[%d]", Integer.valueOf(this.ArI.size()), Integer.valueOf(size));
            AppMethodBeat.o(256992);
            return null;
        }
        GalleryItem.MediaItem mediaItem = this.ArI.get(size);
        AppMethodBeat.o(256992);
        return mediaItem;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0002 !B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "iv", "Landroid/widget/ImageView;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "ivRef", "Ljava/lang/ref/WeakReference;", "tvRef", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setImageView", "setTextView", "Companion", "Listener", "plugin-mv_release"})
    public static final class e implements Runnable {
        public static final a ArP = new a((byte) 0);
        private static final HashMap<TextView, e> xnK = new HashMap<>();
        private WeakReference<ImageView> ArN;
        private final AbstractC1552b ArO;
        boolean ifz;
        private WeakReference<TextView> sTx;
        private final GalleryItem.VideoMediaItem xnI;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "plugin-mv_release"})
        /* renamed from: com.tencent.mm.plugin.mv.ui.adapter.b$e$b  reason: collision with other inner class name */
        public interface AbstractC1552b {
            void a(e eVar, int i2);
        }

        private e(TextView textView, ImageView imageView, GalleryItem.VideoMediaItem videoMediaItem, AbstractC1552b bVar) {
            AppMethodBeat.i(256981);
            this.sTx = new WeakReference<>(textView);
            this.ArN = new WeakReference<>(imageView);
            this.xnI = videoMediaItem;
            this.ArO = bVar;
            AppMethodBeat.o(256981);
        }

        public /* synthetic */ e(TextView textView, ImageView imageView, GalleryItem.VideoMediaItem videoMediaItem, AbstractC1552b bVar, byte b2) {
            this(textView, imageView, videoMediaItem, bVar);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$notifyObserver$1", "Ljava/lang/Runnable;", "run", "", "plugin-mv_release"})
        public static final class c implements Runnable {
            final /* synthetic */ e ArS;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(e eVar) {
                this.ArS = eVar;
            }

            public final void run() {
                AppMethodBeat.i(256975);
                AbstractC1552b bVar = this.ArS.ArO;
                if (bVar != null) {
                    e eVar = this.ArS;
                    GalleryItem.VideoMediaItem videoMediaItem = this.ArS.xnI;
                    if (videoMediaItem == null) {
                        p.hyc();
                    }
                    bVar.a(eVar, videoMediaItem.jkS);
                    AppMethodBeat.o(256975);
                    return;
                }
                AppMethodBeat.o(256975);
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(256976);
            if (!(obj instanceof e)) {
                AppMethodBeat.o(256976);
                return false;
            }
            boolean j2 = p.j(this.xnI, ((e) obj).xnI);
            AppMethodBeat.o(256976);
            return j2;
        }

        public final int hashCode() {
            AppMethodBeat.i(256977);
            GalleryItem.VideoMediaItem videoMediaItem = this.xnI;
            if (videoMediaItem != null) {
                int hashCode = videoMediaItem.hashCode();
                AppMethodBeat.o(256977);
                return hashCode;
            }
            AppMethodBeat.o(256977);
            return 0;
        }

        public final void run() {
            AppMethodBeat.i(256978);
            if (this.ifz) {
                AppMethodBeat.o(256978);
                return;
            }
            GalleryItem.VideoMediaItem videoMediaItem = this.xnI;
            if (videoMediaItem == null) {
                p.hyc();
            }
            String aQn = videoMediaItem.aQn();
            p.g(aQn, "mediaItem!!.thumbPath");
            if (ayX(aQn)) {
                dRS();
            } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_album_get_video_info, 0) == 1) {
                dRS();
            } else {
                long currentTicks = Util.currentTicks();
                com.tencent.mm.compatible.i.c cVar = new com.tencent.mm.compatible.i.c();
                GalleryItem.VideoMediaItem videoMediaItem2 = this.xnI;
                if (videoMediaItem2 == null) {
                    p.hyc();
                }
                String aQn2 = videoMediaItem2.aQn();
                p.g(aQn2, "mediaItem!!.thumbPath");
                try {
                    cVar.setDataSource(aQn2);
                    int trackCount = cVar.getTrackCount();
                    MediaFormat mediaFormat = null;
                    MediaFormat mediaFormat2 = null;
                    for (int i2 = 0; i2 < trackCount; i2++) {
                        MediaFormat trackFormat = cVar.getTrackFormat(i2);
                        p.g(trackFormat, "extractor.getTrackFormat(i)");
                        if (trackFormat.containsKey("mime")) {
                            String string = trackFormat.getString("mime");
                            Log.d("Music.MusicMvAlbumVideoAdapter", "find video mime : %s", string);
                            if (string != null) {
                                if (n.J(string, "video/", false)) {
                                    if (mediaFormat == null) {
                                        mediaFormat = trackFormat;
                                    }
                                } else if (n.J(string, "audio/", false) && mediaFormat2 == null) {
                                    mediaFormat2 = trackFormat;
                                }
                                if (!(mediaFormat2 == null || mediaFormat == null)) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            Log.d("Music.MusicMvAlbumVideoAdapter", "find video mime : not found.");
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
                            this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(aQn2);
                        }
                        if (mediaFormat2 != null) {
                            this.xnI.jkR = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                        }
                    }
                    Log.d("Music.MusicMvAlbumVideoAdapter", "loadItemFromExtractor mediaItem: %s", this.xnI);
                    Log.d("Music.MusicMvAlbumVideoAdapter", "mediaItem format:%s, videoPath:%s", mediaFormat, aQn2);
                    cVar.release();
                } catch (Exception e2) {
                    Log.d("Music.MusicMvAlbumVideoAdapter", "Video extractor init failed. video path = [%s] e = [%s]", aQn2, e2.getMessage());
                    cVar.release();
                } catch (Throwable th) {
                    cVar.release();
                    AppMethodBeat.o(256978);
                    throw th;
                }
                Log.i("Music.MusicMvAlbumVideoAdapter", "loadItemFromExtractor used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            if (!this.ifz) {
                if (p.j(Looper.myLooper(), Looper.getMainLooper())) {
                    AbstractC1552b bVar = this.ArO;
                    if (bVar != null) {
                        GalleryItem.VideoMediaItem videoMediaItem3 = this.xnI;
                        if (videoMediaItem3 == null) {
                            p.hyc();
                        }
                        bVar.a(this, videoMediaItem3.jkS);
                        AppMethodBeat.o(256978);
                        return;
                    }
                    AppMethodBeat.o(256978);
                    return;
                }
                MMHandlerThread.postToMainThread(new c(this));
            }
            AppMethodBeat.o(256978);
        }

        private static boolean ayX(String str) {
            AppMethodBeat.i(256979);
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_album_device_configuration, "");
            p.g(a2, "MMKernel.service(IExptSe…device_configuration, \"\")");
            if (TextUtils.isEmpty(a2)) {
                AppMethodBeat.o(256979);
                return false;
            }
            Log.i("Music.MusicMvAlbumVideoAdapter", "devices configuration: %s", a2);
            Log.i("Music.MusicMvAlbumVideoAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
            try {
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString("devices");
                p.g(optString, "`object`.optString(\"devices\")");
                int optInt = jSONObject.optInt("maxsize");
                JSONArray jSONArray = new JSONArray(optString);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    p.g(optJSONObject, "array.optJSONObject(i)");
                    if (n.I(Build.MANUFACTURER, optJSONObject.optString("brand"), true) && n.I(Build.MODEL, optJSONObject.optString("model"), true)) {
                        long boW = s.boW(str);
                        if (optInt == 0 || boW <= ((long) (optInt * 1024 * 1024))) {
                            int optInt2 = optJSONObject.optInt("androidVersion");
                            if (-1 == optInt2) {
                                Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                                AppMethodBeat.o(256979);
                                return true;
                            } else if (Build.VERSION.SDK_INT == optInt2) {
                                Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                                AppMethodBeat.o(256979);
                                return true;
                            }
                        } else {
                            Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", Long.valueOf(boW), Integer.valueOf(optInt), str);
                            AppMethodBeat.o(256979);
                            return false;
                        }
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("Music.MusicMvAlbumVideoAdapter", e2, "parse json error", new Object[0]);
            }
            AppMethodBeat.o(256979);
            return false;
        }

        private final void dRS() {
            AppMethodBeat.i(256980);
            if (this.xnI == null) {
                AppMethodBeat.o(256980);
                return;
            }
            long currentTicks = Util.currentTicks();
            try {
                String aQn = this.xnI.aQn();
                p.g(aQn, "mediaItem.thumbPath");
                String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(aQn);
                p.g(simpleMp4InfoVFS, "SightVideoJNI.getSimpleMp4InfoVFS(path)");
                Log.d("Music.MusicMvAlbumVideoAdapter", "get simple mp4 info %s", simpleMp4InfoVFS);
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
                Log.printErrStackTrace("Music.MusicMvAlbumVideoAdapter", e2, "loadItemFromSimpleMP4Info fail", new Object[0]);
            }
            Log.d("Music.MusicMvAlbumVideoAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", this.xnI);
            Log.i("Music.MusicMvAlbumVideoAdapter", "loadItemFromSimpleMP4Info used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(256980);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ4\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J4\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "iv", "Landroid/widget/ImageView;", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "videoMinDurationMs", "", "videoMaxDurationMs", "setResult", "durationMs", "plugin-mv_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "plugin-mv_release"})
            /* renamed from: com.tencent.mm.plugin.mv.ui.adapter.b$e$a$a  reason: collision with other inner class name */
            public static final class C1551a implements AbstractC1552b {
                final /* synthetic */ int ArQ;
                final /* synthetic */ int ArR;

                C1551a(int i2, int i3) {
                    this.ArQ = i2;
                    this.ArR = i3;
                }

                @Override // com.tencent.mm.plugin.mv.ui.adapter.b.e.AbstractC1552b
                public final void a(e eVar, int i2) {
                    AppMethodBeat.i(256973);
                    if ((eVar != null ? eVar.sTx : null) == null) {
                        AppMethodBeat.o(256973);
                        return;
                    }
                    WeakReference weakReference = eVar.sTx;
                    if (weakReference == null) {
                        p.hyc();
                    }
                    TextView textView = (TextView) weakReference.get();
                    if (textView == null) {
                        AppMethodBeat.o(256973);
                        return;
                    }
                    ImageView imageView = (ImageView) eVar.ArN.get();
                    if (imageView == null) {
                        AppMethodBeat.o(256973);
                        return;
                    }
                    a aVar = e.ArP;
                    a.a(textView, imageView, i2, this.ArQ, this.ArR);
                    e.xnK.remove(textView);
                    AppMethodBeat.o(256973);
                }
            }

            static void a(TextView textView, ImageView imageView, int i2, int i3, int i4) {
                AppMethodBeat.i(256974);
                if (textView == null) {
                    AppMethodBeat.o(256974);
                } else if (i2 < 0) {
                    textView.setText("--:--");
                    AppMethodBeat.o(256974);
                } else {
                    int Tm = com.tencent.mm.plugin.mv.ui.a.e.Tm(i2);
                    int Tl = com.tencent.mm.plugin.mv.ui.a.e.Tl(i3);
                    int Tn = com.tencent.mm.plugin.mv.ui.a.e.Tn(i4);
                    if (imageView != null) {
                        if (Tm < Tl || Tm > Tn) {
                            imageView.setBackgroundColor(com.tencent.mm.cb.a.n(imageView.getContext(), R.color.ad));
                        } else {
                            imageView.setBackgroundResource(R.drawable.ali);
                        }
                    }
                    String valueOf = String.valueOf(Tm % 60);
                    if (valueOf.length() < 2) {
                        valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(valueOf));
                    }
                    textView.setText(String.valueOf(Tm / 60) + ":" + valueOf);
                    AppMethodBeat.o(256974);
                }
            }
        }

        static {
            AppMethodBeat.i(256982);
            AppMethodBeat.o(256982);
        }

        public static final /* synthetic */ void d(e eVar) {
            AppMethodBeat.i(256983);
            eVar.sTx = new WeakReference<>(null);
            AppMethodBeat.o(256983);
        }

        public static final /* synthetic */ void e(e eVar) {
            AppMethodBeat.i(256984);
            eVar.ArN = new WeakReference<>(null);
            AppMethodBeat.o(256984);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$CameraHeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.adapter.b$b  reason: collision with other inner class name */
    public static final class C1549b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1549b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(256972);
            AppMethodBeat.o(256972);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$AlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "thumbMaskIV", "getThumbMaskIV", "setThumbMaskIV", "typeMaskTV", "Landroid/widget/TextView;", "getTypeMaskTV", "()Landroid/widget/TextView;", "setTypeMaskTV", "(Landroid/widget/TextView;)V", "collapseTouch", "", "delegate", "expandTouch", "plugin-mv_release"})
    public static final class a extends RecyclerView.v {
        ImageView xdY;
        TextView xnB;
        ImageView xnz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(256971);
            View findViewById = view.findViewById(R.id.fc1);
            p.g(findViewById, "itemView.findViewById(R.id.media_thumb)");
            this.xdY = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.fbr);
            p.g(findViewById2, "itemView.findViewById(R.id.media_mask)");
            this.xnz = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.izl);
            p.g(findViewById3, "itemView.findViewById(R.id.type_mask_tv)");
            this.xnB = (TextView) findViewById3;
            AppMethodBeat.o(256971);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ b ArT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(b bVar) {
            this.ArT = bVar;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(256985);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.h(view, "v");
            Object tag = view.getTag(R.id.e3d);
            int intValue = tag instanceof Integer ? ((Number) tag).intValue() : -1;
            Object tag2 = view.getTag(R.id.e42);
            if (tag2 instanceof Integer) {
                i2 = ((Number) tag2).intValue();
            } else {
                i2 = -1;
            }
            if (!(intValue == -1 || i2 == -1 || this.ArT.ArL == null)) {
                d dVar = this.ArT.ArL;
                if (dVar == null) {
                    p.hyc();
                }
                dVar.a(intValue, view, i2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256985);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion;", "", "()V", "ITEM_TYPE_CAMERA_HEADER", "", "ITEM_TYPE_MEDIA", "TAG", "", "CameraHeader", "Header", "plugin-mv_release"})
    public static final class c {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "", "()V", "headerType", "", "getHeaderType", "()I", "setHeaderType", "(I)V", "plugin-mv_release"})
        /* renamed from: com.tencent.mm.plugin.mv.ui.adapter.b$c$b  reason: collision with other inner class name */
        public static abstract class AbstractC1550b {
            int xnH;
        }

        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$CameraHeader;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "headerType", "", "(I)V", "plugin-mv_release"})
        public static final class a extends AbstractC1550b {
            public a() {
                this.xnH = 2;
            }
        }
    }
}
