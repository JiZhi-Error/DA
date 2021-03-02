package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements MStorage.IOnStorageChange {
    protected int aYN = 0;
    private float ayd;
    private float aye;
    private Context mContext;
    protected float oCX;
    private AppBrandRecentView.b oCY;
    List<e> oCZ = new ArrayList();
    private c oDa;
    private a oDb;
    p oDc = null;
    boolean oDd = false;
    protected AppBrandRecentView.f oDe;
    private AppBrandRecentView.d oDf = null;
    private final Object oDg = new Object();
    private boolean oDh = false;
    private MMHandler oDi = null;
    private ConcurrentLinkedQueue<c> oDj = new ConcurrentLinkedQueue<>();
    private AppBrandRecentView.c oDk = new AppBrandRecentView.c<LocalUsageInfo>() {
        /* class com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.c
        public final List<LocalUsageInfo> AC(int i2) {
            AppMethodBeat.i(227795);
            List<LocalUsageInfo> vW = ((ah) g.af(ah.class)).vW(i2);
            AppMethodBeat.o(227795);
            return vW;
        }
    };
    private float oDl = 1.0f;
    private boolean oDm = false;
    List<e> opg = new ArrayList();

    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract int getLoadCount();

    /* access modifiers changed from: protected */
    public abstract int getShowCount();

    /* access modifiers changed from: protected */
    public abstract String getType();

    public void setEnableDataCache(boolean z) {
        this.oDd = z;
    }

    public void setOnDataChangedListener(AppBrandRecentView.d dVar) {
        this.oDf = dVar;
    }

    public BaseAppBrandRecentView(Context context) {
        super(context);
        init(context);
    }

    public BaseAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    /* access modifiers changed from: protected */
    public int getCompletelyCountPerPage() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public float getShowCountPerPage() {
        return 4.0f;
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        this.mContext = context;
        this.oCX = context.getResources().getDimension(R.dimen.be);
        AnonymousClass2 r0 = new LinearLayoutManager() {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        r0.setOrientation(0);
        setLayoutManager(r0);
        setHasFixedSize(true);
        a aVar = new a(this, (byte) 0);
        this.oDb = aVar;
        setAdapter(aVar);
        this.oDc = new p(getCustomItemCount());
        p pVar = this.oDc;
        Context context2 = getContext();
        int completelyCountPerPage = getCompletelyCountPerPage();
        pVar.mContext = context2;
        pVar.oDO = this;
        pVar.oDS = completelyCountPerPage;
        pVar.oDO.b(pVar);
        pVar.oDO.a(pVar);
        pVar.oDV = (LinearLayoutManager) pVar.oDO.getLayoutManager();
        pVar.mSmoothScroller = new ae(pVar.oDO.getContext()) {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.p.AnonymousClass1 */

            @Override // android.support.v7.widget.ae
            public final int kz() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 80.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                AppMethodBeat.i(227836);
                int cd = super.cd(i2);
                AppMethodBeat.o(227836);
                return cd;
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(227837);
                PointF bZ = ((LinearLayoutManager) p.this.oDO.getLayoutManager()).bZ(i2);
                AppMethodBeat.o(227837);
                return bZ;
            }

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void onStop() {
                AppMethodBeat.i(227838);
                super.onStop();
                AppMethodBeat.o(227838);
            }
        };
        pVar.oDR = new ae(pVar.oDO.getContext()) {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.p.AnonymousClass2 */

            @Override // android.support.v7.widget.ae
            public final int kz() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 40.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(227839);
                PointF bZ = ((LinearLayoutManager) p.this.oDO.getLayoutManager()).bZ(i2);
                AppMethodBeat.o(227839);
                return bZ;
            }

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void onStop() {
                AppMethodBeat.i(227840);
                super.onStop();
                Log.i("ViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(p.this.oDO.getScrollState()));
                if (p.this.oDO.getScrollState() == 0) {
                    p.this.ccZ();
                }
                AppMethodBeat.o(227840);
            }
        };
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean ak(int i2, int i3) {
        p pVar = this.oDc;
        pVar.W(pVar.AE(pVar.mOffsetX + i2), false);
        return super.ak(i2, i3);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ayd = motionEvent.getRawX();
            this.aye = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2 && this.oDm) {
            return true;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.oDm = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontally(int i2) {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.aYN = getMeasuredWidth();
        Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", Integer.valueOf(this.aYN));
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public void setOnItemClickListener(AppBrandRecentView.b bVar) {
        this.oCY = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public final void refresh() {
        if (this.oDi == null) {
            this.oDi = new MMHandler("UpdateAppBrandList_" + this.oDe);
        }
        synchronized (this.oDg) {
            if (this.oDh) {
                Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", this.oDe);
                if (this.oDj.size() <= 0) {
                    Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
                    this.oDj.add(new c());
                }
            } else {
                this.oDh = true;
                this.oDi.postToWorker(new c());
            }
        }
    }

    public void setType(AppBrandRecentView.f fVar) {
        this.oDe = fVar;
        if (this.oDe == AppBrandRecentView.f.MY_APP_BRAND) {
            if (g.af(ag.class) != null) {
                ((ag) g.af(ag.class)).add(this);
            }
        } else if (this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND && g.af(ah.class) != null) {
            ((ah) g.af(ah.class)).add(this);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public void setDataQuery(AppBrandRecentView.c cVar) {
        this.oDk = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public final void release() {
        if (this.oDe == AppBrandRecentView.f.MY_APP_BRAND) {
            if (g.af(ag.class) != null) {
                ((ag) g.af(ag.class)).remove(this);
            }
        } else if (this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND && g.af(ah.class) != null) {
            ((ah) g.af(ah.class)).remove(this);
        }
        if (this.oDa != null) {
            this.oDa.cancel();
        }
        this.oCZ.clear();
        if (this.oDi != null) {
            this.oDi.quit();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public AppBrandRecentView.b getOnItemClickListener() {
        return this.oCY;
    }

    public void bX(List<e> list) {
    }

    public int getCustomItemCount() {
        return 0;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", g.aAe().azG().toString(), Integer.valueOf(mStorageEventData.eventId), this.oDe);
        if (mStorageEventData.eventId != 5 || !ccX()) {
            refresh();
        } else {
            Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        }
    }

    /* access modifiers changed from: protected */
    public boolean ccX() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView, android.support.v7.widget.RecyclerView
    public RecyclerView.a getAdapter() {
        return this.oDb;
    }

    /* access modifiers changed from: protected */
    public class a extends RecyclerView.a<b> {
        c.a oDo;

        /* synthetic */ a(BaseAppBrandRecentView baseAppBrandRecentView, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(227798);
            b bVar2 = bVar;
            bVar2.ooD.setVisibility(8);
            if (bVar2.ooF != null) {
                bVar2.ooF.setVisibility(8);
            }
            if (i2 >= BaseAppBrandRecentView.this.oCZ.size() || i2 - BaseAppBrandRecentView.this.getCustomItemCount() > BaseAppBrandRecentView.this.getShowCount()) {
                bVar2.aus.setVisibility(4);
                BaseAppBrandRecentView.this.a(bVar2, (e) null, i2);
                AppMethodBeat.o(227798);
                return;
            }
            bVar2.aus.setVisibility(0);
            e eVar = (e) BaseAppBrandRecentView.this.oCZ.get(i2);
            if (eVar != null) {
                eVar.position = i2;
                bVar2.aus.setTag(eVar);
            }
            if (eVar.ooj != null && !Util.isNullOrNil(e.vO(eVar.ooj.iOo))) {
                bVar2.ooD.setVisibility(0);
                bVar2.ooD.setText(e.vO(eVar.ooj.iOo));
            } else if (!(bVar2.ooF == null || eVar.ooj == null || !eVar.ooj.kWc)) {
                bVar2.ooF.setVisibility(0);
                bVar2.ooF.setImageResource(R.raw.ok_icon);
            }
            BaseAppBrandRecentView.this.a(bVar2, eVar, i2);
            AppMethodBeat.o(227798);
        }

        private a() {
            AppMethodBeat.i(227796);
            this.oDo = new c.a();
            this.oDo.jbq = R.raw.default_avatar;
            AppMethodBeat.o(227796);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2;
            AppMethodBeat.i(227797);
            int size = BaseAppBrandRecentView.this.oCZ.size();
            int completelyCountPerPage = BaseAppBrandRecentView.this.getCompletelyCountPerPage();
            if (BaseAppBrandRecentView.this.getCustomItemCount() == 1) {
                size--;
            }
            if (size > BaseAppBrandRecentView.this.getShowCount()) {
                size = BaseAppBrandRecentView.this.getShowCount();
            }
            if (BaseAppBrandRecentView.this.getCustomItemCount() == 1) {
                if (size % completelyCountPerPage == 0) {
                    i2 = size + 1;
                } else {
                    i2 = size + ((completelyCountPerPage + 1) - (size % completelyCountPerPage));
                }
                int customItemCount = i2 + BaseAppBrandRecentView.this.getCustomItemCount();
                AppMethodBeat.o(227797);
                return customItemCount;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.o(227797);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(227799);
            b bVar = new b(aa.jQ(BaseAppBrandRecentView.this.mContext).inflate(BaseAppBrandRecentView.this.getLayoutId(), viewGroup, false));
            AppMethodBeat.o(227799);
            return bVar;
        }
    }

    public int getItemWidth() {
        return 0;
    }

    public void a(b bVar, e eVar, int i2) {
        int itemWidth = getItemWidth();
        float showCountPerPage = getShowCountPerPage();
        if (itemWidth <= 0) {
            itemWidth = (int) (((float) getWidth()) / showCountPerPage);
        }
        if (itemWidth <= 0) {
            itemWidth = (int) (((float) getResources().getDisplayMetrics().widthPixels) / showCountPerPage);
        }
        if (i2 == this.oDb.getItemCount() - 1) {
            itemWidth = (int) ((1.0d - (Math.ceil((double) showCountPerPage) - ((double) showCountPerPage))) * ((double) itemWidth));
            Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i2), Integer.valueOf(itemWidth));
        }
        bVar.aus.getLayoutParams().width = itemWidth;
        bVar.aus.setScaleX(1.0f);
        bVar.aus.setScaleY(1.0f);
        Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i2), Integer.valueOf(itemWidth));
        if (eVar != null && eVar.type == 1 && eVar.ooj != null) {
            if (!Util.isNullOrNil(eVar.ooj.cyB)) {
                bVar.titleTv.setText(agj(eVar.ooj.cyB));
                bVar.titleTv.setVisibility(0);
            } else if (!Util.isNullOrNil(eVar.ooj.nickname)) {
                bVar.titleTv.setText(agj(eVar.ooj.nickname));
                bVar.titleTv.setVisibility(0);
            } else if (!Util.isNullOrNil(eVar.ooj.username)) {
                bVar.titleTv.setText(eVar.ooj.username);
                bVar.titleTv.setVisibility(0);
            } else {
                Log.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", eVar.ooj.username, eVar.ooj.appId);
                bVar.titleTv.setText("");
                bVar.titleTv.setVisibility(4);
            }
            bVar.ooB.setVisibility(0);
            if (!Util.isNullOrNil(eVar.ooj.kVZ)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(bVar.nnL, eVar.ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
            } else {
                bVar.nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
            }
        }
    }

    private static String agj(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (f.bnP(str) <= 11) {
                return str;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                i4 += f.bnP(String.valueOf(charArray[i2]));
                if (i4 >= 11) {
                    return str.substring(0, i3) + (char) 8230;
                }
                i2++;
                i3++;
            }
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public class b extends RecyclerView.v {
        public View aus;
        public ImageView nnL;
        public RelativeLayout oDp;
        public ImageView ooB;
        public TextView ooD;
        public ImageView ooF;
        public TextView titleTv;

        public b(View view) {
            super(view);
            AppMethodBeat.i(227802);
            this.aus = view;
            view.setOnClickListener(new View.OnClickListener(BaseAppBrandRecentView.this) {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(227800);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    e eVar = (e) view.getTag();
                    eVar.position = b.this.lR();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().a(view, eVar, BaseAppBrandRecentView.this.ayd, BaseAppBrandRecentView.this.aye);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(227800);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(BaseAppBrandRecentView.this) {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView.b.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(227801);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    e eVar = (e) view.getTag();
                    eVar.position = b.this.lR();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().b(view, eVar, BaseAppBrandRecentView.this.ayd, BaseAppBrandRecentView.this.aye);
                    }
                    BaseAppBrandRecentView.this.oDm = true;
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(227801);
                    return true;
                }
            });
            view.getLayoutParams().width = BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.nnL = (ImageView) view.findViewById(R.id.dt5);
            this.ooB = (ImageView) view.findViewById(R.id.dtj);
            this.oDp = (RelativeLayout) view.findViewById(R.id.dty);
            this.titleTv = (TextView) view.findViewById(R.id.ipm);
            this.ooD = (TextView) view.findViewById(R.id.ijm);
            this.ooF = (ImageView) view.findViewById(R.id.dwa);
            AppMethodBeat.o(227802);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView
    public int getCount() {
        return this.oCZ.size();
    }

    /* access modifiers changed from: package-private */
    public class c extends com.tencent.f.i.b {
        List<e> nZr;
        List<e> oDs;
        boolean oDt;

        public c() {
            AppMethodBeat.i(227804);
            this.oDt = true;
            this.oDt = true;
            this.nZr = new ArrayList();
            this.oDs = new ArrayList();
            AppMethodBeat.o(227804);
        }

        public final void run() {
            AppMethodBeat.i(227805);
            synchronized (BaseAppBrandRecentView.this.oDg) {
                try {
                    BaseAppBrandRecentView.this.oDh = true;
                } catch (Throwable th) {
                    AppMethodBeat.o(227805);
                    throw th;
                }
            }
            List<LocalUsageInfo> list = null;
            if (BaseAppBrandRecentView.this.oDk != null) {
                list = BaseAppBrandRecentView.this.oDk.AC(BaseAppBrandRecentView.this.getLoadCount());
            }
            this.nZr.clear();
            this.oDs.clear();
            if (list != null) {
                LocalUsageInfo bRO = BaseAppBrandRecentView.this.getSceneFactory() != null ? BaseAppBrandRecentView.this.getSceneFactory().bRO() : null;
                for (LocalUsageInfo localUsageInfo : list) {
                    if (bRO == null || !localUsageInfo.username.equals(bRO.username) || localUsageInfo.iOo != bRO.iOo) {
                        if (this.nZr.size() < BaseAppBrandRecentView.this.getShowCount()) {
                            this.nZr.add(new e(localUsageInfo));
                        }
                        if (BaseAppBrandRecentView.this.oDd) {
                            this.oDs.add(new e(localUsageInfo));
                        }
                        Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", localUsageInfo.username, localUsageInfo.nickname, localUsageInfo.cyB, localUsageInfo.kVZ, localUsageInfo.appId, Integer.valueOf(localUsageInfo.iOo), BaseAppBrandRecentView.this.oDe);
                    }
                }
            }
            BaseAppBrandRecentView.this.bX(this.nZr);
            Log.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.this.oCZ.size()), Integer.valueOf(BaseAppBrandRecentView.this.opg.size()), BaseAppBrandRecentView.this.oDe);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(227803);
                    BaseAppBrandRecentView.this.oCZ.clear();
                    BaseAppBrandRecentView.this.opg.clear();
                    BaseAppBrandRecentView.this.oCZ.addAll(c.this.nZr);
                    BaseAppBrandRecentView.this.opg.addAll(c.this.oDs);
                    c.this.nZr.clear();
                    c.this.oDs.clear();
                    if (BaseAppBrandRecentView.this.getRefreshListener() != null && c.this.oDt) {
                        BaseAppBrandRecentView.this.getRefreshListener().yL(BaseAppBrandRecentView.this.oCZ.size());
                    }
                    if (c.this.oDt) {
                        Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", BaseAppBrandRecentView.this.oDe);
                        AppBrandRecentView.f fVar = AppBrandRecentView.f.RECENT_APP_BRAND;
                        BaseAppBrandRecentView.this.getAdapter().atj.notifyChanged();
                    }
                    synchronized (BaseAppBrandRecentView.this.oDg) {
                        try {
                            BaseAppBrandRecentView.this.oDh = false;
                        } catch (Throwable th) {
                            AppMethodBeat.o(227803);
                            throw th;
                        }
                    }
                    BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
                    AppMethodBeat.o(227803);
                }
            });
            AppMethodBeat.o(227805);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MicroMsg.BaseAppBrandRecentView";
        }
    }

    /* access modifiers changed from: protected */
    public void AD(int i2) {
        if (this.oDd && i2 - 1 < this.opg.size()) {
            this.opg.remove(i2 - 1);
        }
    }

    /* access modifiers changed from: protected */
    public AppBrandRecentView.d getOnDataChangedListener() {
        return this.oDf;
    }

    public List<e> getPreviewItemList() {
        if (this.oCZ == null) {
            this.oCZ = new ArrayList();
        }
        return this.oCZ;
    }

    public int getDataCount() {
        if (this.oCZ != null) {
            return this.oCZ.size();
        }
        return 0;
    }

    public int getCurrentPage() {
        if (this.oDc != null) {
            return this.oDc.owW;
        }
        return 0;
    }

    public void setOnScrollPageListener(p.a aVar) {
        if (this.oDc != null) {
            this.oDc.oDX = aVar;
        }
    }

    static /* synthetic */ void j(BaseAppBrandRecentView baseAppBrandRecentView) {
        c poll;
        synchronized (baseAppBrandRecentView.oDg) {
            if (baseAppBrandRecentView.oDj.size() > 0 && (poll = baseAppBrandRecentView.oDj.poll()) != null) {
                baseAppBrandRecentView.oDi.postToWorker(poll);
            }
        }
    }
}
