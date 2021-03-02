package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001b\u001a\u00020\u0017H\u0016J,\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010\"\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "continueFlag", "finderPullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestId", "", "searchOffset", "getFeedFrom", "initSearch", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "Companion", "plugin-mv_release"})
public final class MusicMvTabSearchFragment extends MusicMvTabFragment implements i {
    public static final a Azs = new a((byte) 0);
    private int Azq;
    private int Azr;
    private HashMap _$_findViewCache;
    private int continueFlag;
    private String dPI;
    private b lastBuffer;

    static {
        AppMethodBeat.i(257723);
        AppMethodBeat.o(257723);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final View ewN() {
        AppMethodBeat.i(257724);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.fps));
        if (view == null) {
            view = findViewById(R.id.fps);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.fps), view);
        }
        AppMethodBeat.o(257724);
        return view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvTabSearchFragment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(257720);
        AppMethodBeat.o(257720);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvTabSearchFragment(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
        p.h(context, "context");
        AppMethodBeat.i(257721);
        AppMethodBeat.o(257721);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private MusicMvTabSearchFragment(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        p.h(context, "context");
        AppMethodBeat.i(257722);
        g.azz().a(3820, this);
        AppMethodBeat.o(257722);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final void onDestroy() {
        AppMethodBeat.i(257716);
        super.onDestroy();
        g.azz().b(3820, this);
        AppMethodBeat.o(257716);
    }

    public final void aIs(String str) {
        TextView textView;
        AppMethodBeat.i(257717);
        getRlLayout().setHasBottomMore(true);
        TextView loadingTv = getLoadingTv();
        if (loadingTv != null) {
            loadingTv.setVisibility(8);
        }
        View loadMoreFooter = getRlLayout().getLoadMoreFooter();
        if (loadMoreFooter != null) {
            loadMoreFooter.setVisibility(4);
        }
        View loadMoreFooter2 = getRlLayout().getLoadMoreFooter();
        if (!(loadMoreFooter2 == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
            textView.setVisibility(0);
        }
        this.dPI = UUID.randomUUID().toString();
        this.lastBuffer = null;
        this.Azq = 0;
        getDataList().clear();
        a(null, str);
        AppMethodBeat.o(257717);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, String str) {
        AppMethodBeat.i(257718);
        super.a(aVar, str);
        if (this.dPI == null) {
            this.dPI = UUID.randomUUID().toString();
        }
        String str2 = this.dPI;
        if (str2 != null) {
            if (str != null) {
                String str3 = str.length() > 0 ? str : null;
                if (str3 != null) {
                    bbn bbn = new bbn();
                    bbn.tCE = 93;
                    g.azz().b(new cf(str3, this.Azq, str2, this.lastBuffer, 12, bbn, 64));
                    com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                    com.tencent.mm.plugin.mv.a.l.iv(str3, "");
                    AppMethodBeat.o(257718);
                    return;
                }
            }
            AppMethodBeat.o(257718);
            return;
        }
        AppMethodBeat.o(257718);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment, com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(257719);
        if (qVar instanceof cf) {
            if (i2 == 0 && i3 == 0) {
                this.lastBuffer = ((cf) qVar).twl.tVM;
                this.Azr = 2;
                bcb bcb = ((cf) qVar).twl;
                this.Azq = bcb.offset;
                this.continueFlag = bcb.continueFlag;
                setHasMore(this.continueFlag != 0);
                Iterator<FinderObject> it = bcb.tbD.iterator();
                while (it.hasNext()) {
                    FinderObject next = it.next();
                    if (next != null) {
                        long j2 = next.id;
                        String str2 = next.objectNonceId;
                        if (!getFeedIdMap().contains(Long.valueOf(j2))) {
                            getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(j2, str2, next)));
                        }
                    }
                }
                getAdapter().notifyDataSetChanged();
                Log.i("Music.MusicMvTabFragment", "onSceneEnd BGFinderFeed " + getDataList().size());
            }
            getRlLayout().apT(0);
            MusicMvTabFragment.c resultListener = getResultListener();
            if (resultListener != null) {
                resultListener.hx(4, getAdapter().getItemCount());
                AppMethodBeat.o(257719);
                return;
            }
        }
        AppMethodBeat.o(257719);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
    public final int getFeedFrom() {
        return 7;
    }
}
