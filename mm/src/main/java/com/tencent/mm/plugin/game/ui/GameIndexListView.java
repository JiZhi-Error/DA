package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView extends LoadMoreRecyclerView {
    private static boolean xPA;
    private static int xPC = 0;
    private static boolean xPx = true;
    private static int xSP = 0;
    private static int xSY = 0;
    private View agA;
    private Context mContext;
    private Scroller mScroller;
    private int rZ;
    private boolean xPB;
    private ImageView xPD;
    private ImageView xPE;
    private float xPy;
    b xSV;
    private bm xSW;
    private boolean xSX = true;

    static /* synthetic */ void a(GameIndexListView gameIndexListView) {
        AppMethodBeat.i(42169);
        gameIndexListView.dWp();
        AppMethodBeat.o(42169);
    }

    public static void setSourceScene(int i2) {
        xSP = i2;
    }

    public static int getSourceScene() {
        return xSP;
    }

    public GameIndexListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42164);
        super.onFinishInflate();
        Log.d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.rZ = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.xSV = new b();
        setAdapter(this.xSV);
        a(new a(getResources()));
        setLoadingView(R.layout.aq9);
        setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a() {
            /* class com.tencent.mm.plugin.game.ui.GameIndexListView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
            public final void bYy() {
                AppMethodBeat.i(42153);
                GameIndexListView.a(GameIndexListView.this);
                AppMethodBeat.o(42153);
            }
        });
        showLoading(true);
        dWp();
        AppMethodBeat.o(42164);
    }

    private void dWp() {
        com.tencent.mm.bw.b bVar;
        com.tencent.mm.vending.e.b bVar2;
        AppMethodBeat.i(42165);
        d.a aVar = new d.a();
        bl blVar = new bl();
        if (this.xSW != null) {
            bVar = this.xSW.xLD;
        } else {
            bVar = null;
        }
        blVar.xLB = bVar;
        aVar.iLN = blVar;
        aVar.iLO = new bm();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        aVar.funcId = 2943;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        AnonymousClass2 r3 = new aa.a() {
            /* class com.tencent.mm.plugin.game.ui.GameIndexListView.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                LinkedList linkedList;
                AppMethodBeat.i(42154);
                Log.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    GameIndexListView.this.xSW = (bm) dVar.iLL.iLR;
                    bm bmVar = GameIndexListView.this.xSW;
                    boolean z = GameIndexListView.this.xSX;
                    if (bmVar == null || Util.isNullOrNil(bmVar.xLC)) {
                        linkedList = null;
                    } else {
                        LinkedList linkedList2 = new LinkedList();
                        if (z && !Util.isNullOrNil(bmVar.xJu)) {
                            com.tencent.mm.plugin.game.model.d dVar2 = new com.tencent.mm.plugin.game.model.d();
                            dVar2.type = 2000;
                            dVar2.xEp = bmVar.xJu;
                            linkedList2.add(dVar2);
                        }
                        Iterator<ao> it = bmVar.xLC.iterator();
                        while (it.hasNext()) {
                            ao next = it.next();
                            if (next.xJy != 7) {
                                com.tencent.mm.plugin.game.model.d dVar3 = new com.tencent.mm.plugin.game.model.d();
                                dVar3.type = next.xJy;
                                dVar3.position = next.xJv;
                                dVar3.xEq = next;
                                linkedList2.add(dVar3);
                            } else if (next.xKv != null && !Util.isNullOrNil(next.xKv.xJs)) {
                                if (!Util.isNullOrNil(next.xKv.Title)) {
                                    com.tencent.mm.plugin.game.model.d dVar4 = new com.tencent.mm.plugin.game.model.d();
                                    dVar4.xEq = next;
                                    dVar4.type = 1000;
                                    linkedList2.add(dVar4);
                                }
                                Iterator<ah> it2 = next.xKv.xJs.iterator();
                                while (it2.hasNext()) {
                                    com.tencent.mm.plugin.game.model.d dVar5 = new com.tencent.mm.plugin.game.model.d();
                                    dVar5.xEq = next;
                                    dVar5.type = 1001;
                                    dVar5.xEr = next.xKv.xJs.indexOf(it2.next());
                                    linkedList2.add(dVar5);
                                }
                                com.tencent.mm.plugin.game.model.d dVar6 = new com.tencent.mm.plugin.game.model.d();
                                dVar6.xEq = next;
                                dVar6.type = 1002;
                                linkedList2.add(dVar6);
                            }
                        }
                        linkedList = linkedList2;
                    }
                    GameIndexListView.this.xSX = false;
                    ad.a(GameIndexListView.this.xSW);
                    if (!GameIndexListView.this.xSW.xLE) {
                        GameIndexListView.this.showLoading(false);
                    }
                    if (!Util.isNullOrNil(linkedList)) {
                        b bVar = GameIndexListView.this.xSV;
                        bVar.xTa.addAll(linkedList);
                        bVar.atj.notifyChanged();
                    }
                }
                AppMethodBeat.o(42154);
                return 0;
            }
        };
        if (this.mContext instanceof com.tencent.mm.vending.e.b) {
            bVar2 = (com.tencent.mm.vending.e.b) this.mContext;
        } else {
            bVar2 = null;
        }
        aa.a(aXF, r3, false, bVar2);
        AppMethodBeat.o(42165);
    }

    public class b extends RecyclerView.a<a> {
        LinkedList<com.tencent.mm.plugin.game.model.d> xTa = new LinkedList<>();

        public b() {
            AppMethodBeat.i(42159);
            AppMethodBeat.o(42159);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(42162);
            a aVar2 = aVar;
            Log.d("MicroMsg.GameIndexListView", "onBindViewHolder， position = %d", Integer.valueOf(i2));
            com.tencent.mm.plugin.game.model.d dVar = this.xTa.get(i2);
            if (dVar != null) {
                switch (dVar.type) {
                    case 1:
                        ((GameFeedImageTextView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 2:
                        ((GameFeedVideoView) aVar2.contentView).setVideoData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 3:
                        ((GameFeedVideoView) aVar2.contentView).setLiveData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 4:
                        ((GameFeedMatchView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 5:
                        ((GameFeedGameTemplateView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 6:
                        ((GameFeedNoGamePlayTemplate) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 8:
                        ((GameFeedAddTopicView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 9:
                        ((GameFeedMoreGameEntranceView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 10:
                        ((GameFeedQipaiView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 1000:
                        ((GameBestSellingTitle) aVar2.contentView).setText(dVar.xEq.xKv.Title);
                        AppMethodBeat.o(42162);
                        return;
                    case 1001:
                        ((GameBestSellingItemView) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                    case 1002:
                        ((GameBestSellingMore) aVar2.contentView).setData(dVar);
                        break;
                    case 2000:
                        ((GameFeedModuleTitle) aVar2.contentView).setData(dVar);
                        AppMethodBeat.o(42162);
                        return;
                }
            }
            AppMethodBeat.o(42162);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(42160);
            int i3 = this.xTa.get(i2).type;
            AppMethodBeat.o(42160);
            return i3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(42161);
            int size = this.xTa.size();
            AppMethodBeat.o(42161);
            return size;
        }

        public class a extends RecyclerView.v {
            public View contentView;

            public a(View view) {
                super(view);
                AppMethodBeat.i(42158);
                this.contentView = ((ViewGroup) view).getChildAt(0);
                AppMethodBeat.o(42158);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            View inflate;
            AppMethodBeat.i(42163);
            Log.d("MicroMsg.GameIndexListView", "onCreateViewHolder, viewType = ".concat(String.valueOf(i2)));
            switch (i2) {
                case 1:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aq8, viewGroup, false);
                    break;
                case 2:
                case 3:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aqh, viewGroup, false);
                    break;
                case 4:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aq_, viewGroup, false);
                    break;
                case 5:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aq7, viewGroup, false);
                    break;
                case 6:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aqc, viewGroup, false);
                    break;
                case 8:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aq6, viewGroup, false);
                    break;
                case 9:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aqb, viewGroup, false);
                    break;
                case 10:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aqe, viewGroup, false);
                    break;
                case 1000:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aoq, viewGroup, false);
                    break;
                case 1001:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aoo, viewGroup, false);
                    break;
                case 1002:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aop, viewGroup, false);
                    break;
                case 2000:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.layout.aqa, viewGroup, false);
                    break;
                default:
                    inflate = new FrameLayout(GameIndexListView.this.getContext());
                    break;
            }
            a aVar = new a(inflate);
            AppMethodBeat.o(42163);
            return aVar;
        }
    }

    public class a extends RecyclerView.h {
        private final Drawable amP;
        private int mSize;

        public a(Resources resources) {
            AppMethodBeat.i(42155);
            this.amP = new ColorDrawable(resources.getColor(R.color.s8));
            this.mSize = resources.getDimensionPixelSize(R.dimen.g1);
            AppMethodBeat.o(42155);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(42156);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount - 1; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                    super.a(canvas, recyclerView, sVar);
                } else {
                    int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                    this.amP.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                    this.amP.draw(canvas);
                }
            }
            AppMethodBeat.o(42156);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(42157);
            rect.set(0, 0, 0, this.mSize);
            AppMethodBeat.o(42157);
        }
    }

    public static void setCanPulldown(boolean z) {
        xPA = z;
    }

    public static void setDefaultPadding(int i2) {
        xPC = i2;
    }

    public static void setInitPadding(int i2) {
        xSY = i2;
        xPx = true;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(42166);
        Log.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(z)));
        super.onLayout(z, i2, i3, i4, i5);
        if (xPx || this.agA == null || this.xPE == null || this.xPD == null) {
            this.agA = getChildAt(0);
            if (this.agA != null) {
                this.agA.setPadding(0, xSY, 0, 0);
                this.xPE = (ImageView) this.agA.findViewById(R.id.ht0);
                this.xPD = (ImageView) this.agA.findViewById(R.id.a3g);
            }
            xPx = false;
        }
        AppMethodBeat.o(42166);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(42167);
        if (!xPA || this.agA == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(42167);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xPB = false;
                this.xPy = motionEvent.getRawY();
                break;
            case 2:
                if (((LinearLayoutManager) getLayoutManager()).ks() == 0 && this.agA != null && this.agA.getTop() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.xPB) {
                        AppMethodBeat.o(42167);
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.xPy);
                    if (this.agA.getPaddingTop() <= xPC + this.rZ) {
                        if (rawY > 0 && Math.abs(rawY) >= this.rZ) {
                            this.xPB = true;
                            this.mScroller.startScroll(0, this.agA.getPaddingTop(), 0, -this.agA.getPaddingTop(), 500);
                            this.xPD.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            AppMethodBeat.o(42167);
                            return true;
                        }
                    } else if (this.agA.getPaddingTop() >= (-this.rZ) && rawY < 0 && Math.abs(rawY) >= this.rZ) {
                        this.xPB = true;
                        this.mScroller.startScroll(0, 0, 0, xPC, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(42167);
                        return true;
                    }
                }
                break;
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(42167);
        return dispatchTouchEvent2;
    }

    public void computeScroll() {
        AppMethodBeat.i(42168);
        if (this.agA == null) {
            AppMethodBeat.o(42168);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            Log.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(currY)));
            this.agA.setPadding(0, currY, 0, 0);
            float f2 = (((float) (xPC - currY)) / ((float) xPC)) * 255.0f;
            this.xPE.setAlpha(255 - ((int) f2));
            this.xPD.setAlpha((int) f2);
            invalidate();
        }
        AppMethodBeat.o(42168);
    }
}
