package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.a.a.e;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyFavFragment extends MusicMvTabFragment implements i {
    public static final a Azn = new a((byte) 0);
    private HashMap _$_findViewCache;
    private b lastBuffer;
    private int uDV;

    static {
        AppMethodBeat.i(257698);
        AppMethodBeat.o(257698);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final View ewN() {
        AppMethodBeat.i(257699);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.fps));
        if (view == null) {
            view = findViewById(R.id.fps);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.fps), view);
        }
        AppMethodBeat.o(257699);
        return view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvTabMyFavFragment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(257695);
        AppMethodBeat.o(257695);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvTabMyFavFragment(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
        p.h(context, "context");
        AppMethodBeat.i(257696);
        AppMethodBeat.o(257696);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private MusicMvTabMyFavFragment(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        p.h(context, "context");
        AppMethodBeat.i(257697);
        g.azz().a(3966, this);
        AppMethodBeat.o(257697);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final void onDestroy() {
        AppMethodBeat.i(257692);
        super.onDestroy();
        g.azz().b(3966, this);
        AppMethodBeat.o(257692);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, String str) {
        AppMethodBeat.i(257693);
        super.a(aVar, str);
        String aUg = z.aUg();
        p.g(aUg, "finderUsername");
        g.azz().b(new e(aUg, this.lastBuffer));
        AppMethodBeat.o(257693);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment, com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        Integer num;
        boolean z;
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        AppMethodBeat.i(257694);
        if (qVar instanceof e) {
            if (i2 == 0 && i3 == 0) {
                asa asa = ((e) qVar).AqB;
                this.lastBuffer = asa != null ? asa.lastBuffer : null;
                asa asa2 = ((e) qVar).AqB;
                if (asa2 != null) {
                    this.uDV = asa2.gAZ;
                    Iterator<FinderObject> it = asa2.object.iterator();
                    while (it.hasNext()) {
                        FinderObject next = it.next();
                        if (next != null) {
                            FinderObjectDesc finderObjectDesc = next.objectDesc;
                            if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null || finderMedia.mediaType != 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                long j2 = next.id;
                                String str2 = next.objectNonceId;
                                if (!getFeedIdMap().contains(Long.valueOf(j2))) {
                                    getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(j2, str2, next)));
                                }
                            }
                        }
                    }
                    getAdapter().notifyDataSetChanged();
                    asa asa3 = ((e) qVar).AqB;
                    if (asa3 != null) {
                        num = Integer.valueOf(asa3.continueFlag);
                    } else {
                        num = null;
                    }
                    setHasMore(num == null || num.intValue() != 0);
                    Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore());
                }
            }
            getRlLayout().apT(0);
            MusicMvTabFragment.c resultListener = getResultListener();
            if (resultListener != null) {
                resultListener.hx(2, getAdapter().getItemCount());
            }
            WxRecyclerAdapter<MusicMvTabFragment.d> adapter = getAdapter();
            if ((adapter != null ? Integer.valueOf(adapter.getItemCount()) : null).intValue() == 0) {
                LinearLayout emptyLL = getEmptyLL();
                if (emptyLL != null) {
                    emptyLL.setVisibility(0);
                }
            } else {
                LinearLayout emptyLL2 = getEmptyLL();
                if (emptyLL2 != null) {
                    emptyLL2.setVisibility(8);
                }
            }
            TextView loadingTv = getLoadingTv();
            if (loadingTv != null) {
                loadingTv.setVisibility(8);
                AppMethodBeat.o(257694);
                return;
            }
        }
        AppMethodBeat.o(257694);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final int getFeedFrom() {
        return 5;
    }
}