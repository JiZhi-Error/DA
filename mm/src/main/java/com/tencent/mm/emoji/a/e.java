package com.tencent.mm.emoji.a;

import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.a.a;
import com.tencent.mm.emoji.a.b;
import com.tencent.mm.emoji.a.c;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020 J\u0016\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "", "()V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "holderCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "holderPool", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "rootLocation", "", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;)V", "checkMatch", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "checkRevoke", "", "onStop", "setPlayingKey", "itemHolder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "emojiKey", "updateItemView", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "Companion", "StateCallback", "plugin-emojisdk_release"})
public final class e {
    private static final String TAG = TAG;
    public static final a gVu = new a((byte) 0);
    public FrameLayout gUY;
    public final d gVq = new d();
    private final c.a gVr = new c.a(this) {
        /* class com.tencent.mm.emoji.a.e.AnonymousClass1 */
        final /* synthetic */ e gVv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.gVv = r1;
        }

        @Override // com.tencent.mm.emoji.a.c.a
        public final void a(c cVar) {
            AppMethodBeat.i(199886);
            p.h(cVar, "holder");
            this.gVv.gVq.b(cVar);
            AppMethodBeat.o(199886);
        }

        @Override // com.tencent.mm.emoji.a.c.a
        public final void a(b.C0317b bVar) {
            AppMethodBeat.i(199887);
            p.h(bVar, "effect");
            b bVar2 = this.gVv.gVt;
            if (bVar2 != null) {
                bVar2.a(bVar);
                AppMethodBeat.o(199887);
                return;
            }
            AppMethodBeat.o(199887);
        }

        @Override // com.tencent.mm.emoji.a.c.a
        public final void a(long j2, b.C0317b bVar) {
            AppMethodBeat.i(199888);
            p.h(bVar, "effect");
            b bVar2 = this.gVv.gVt;
            if (bVar2 != null) {
                bVar2.a(j2, bVar);
                AppMethodBeat.o(199888);
                return;
            }
            AppMethodBeat.o(199888);
        }
    };
    public String gVs;
    public b gVt;
    private final int[] uBR = new int[2];

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
    public interface b {
        void a(long j2, b.C0317b bVar);

        void a(b.C0317b bVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiDynamicController$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public e() {
        AppMethodBeat.i(199892);
        AppMethodBeat.o(199892);
    }

    static {
        AppMethodBeat.i(199893);
        AppMethodBeat.o(199893);
    }

    public final boolean q(ca caVar) {
        T t;
        boolean z;
        int i2;
        b.C0317b bVar;
        c.a aVar;
        int i3;
        AppMethodBeat.i(199889);
        p.h(caVar, "msgInfo");
        f.a aVar2 = f.gVz;
        String r = f.a.r(caVar);
        String str = r;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(199889);
        } else {
            String anj = com.tencent.mm.plugin.emoji.h.b.anj(r);
            String str2 = anj;
            if (!(str2 == null || str2.length() == 0)) {
                d dVar = this.gVq;
                long ajL = caVar.ajL();
                c cVar = new c();
                cVar.msgId = ajL;
                dVar.gVo.add(cVar);
                cVar.msgId = caVar.ajL();
                cVar.gUY = this.gUY;
                cVar.gVj = this.gVr;
                if (caVar.ajN() == 1) {
                    cVar.gVi = new com.tencent.mm.g.b.a.l();
                    com.tencent.mm.g.b.a.l lVar = cVar.gVi;
                    if (lVar != null) {
                        com.tencent.mm.emoji.c.a aVar3 = com.tencent.mm.emoji.c.a.hbZ;
                        if (com.tencent.mm.emoji.c.a.avY()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        lVar.jE(i3);
                    }
                    com.tencent.mm.emoji.c.a aVar4 = com.tencent.mm.emoji.c.a.hbZ;
                    com.tencent.mm.emoji.c.a.ed(false);
                }
                com.tencent.mm.g.b.a.l lVar2 = cVar.gVi;
                if (lVar2 != null) {
                    lVar2.hQ(this.gVs);
                }
                com.tencent.mm.g.b.a.l lVar3 = cVar.gVi;
                if (lVar3 != null) {
                    lVar3.hP(r);
                }
                p.h(cVar, "itemHolder");
                p.h(anj, "emojiKey");
                Log.i(TAG, "setPlayingKey: ".concat(String.valueOf(anj)));
                f.a aVar5 = f.gVz;
                Iterator<T> it = f.gVy.gUV.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.key, anj)) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.emoji.e.a aVar6 = com.tencent.mm.emoji.e.a.hdT;
                    String sb2 = sb.append(com.tencent.mm.emoji.e.a.aww()).append(t2.gUW).toString();
                    if (s.YS(sb2)) {
                        p.h(t2, "config");
                        p.h(sb2, "filePath");
                        cVar.gVc = t2;
                        b.a aVar7 = cVar.gVc;
                        if (!(aVar7 == null || (bVar = aVar7.gUX) == null || (aVar = cVar.gVj) == null)) {
                            aVar.a(bVar);
                        }
                        try {
                            cVar.gVb = new h(s.aW(sb2, 0, -1));
                            if (cVar.gVb != null) {
                                com.tencent.mm.g.b.a.l lVar4 = cVar.gVi;
                                if (lVar4 != null) {
                                    lVar4.jD(1);
                                }
                            } else {
                                com.tencent.mm.g.b.a.l lVar5 = cVar.gVi;
                                if (lVar5 != null) {
                                    lVar5.jD(2);
                                }
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace(cVar.TAG, e2, "create anim", new Object[0]);
                            if (e2 instanceof MMGIFException) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(711, 21);
                                com.tencent.mm.g.b.a.l lVar6 = cVar.gVi;
                                if (lVar6 != null) {
                                    lVar6.jD(2);
                                }
                                com.tencent.mm.g.b.a.l lVar7 = cVar.gVi;
                                if (lVar7 != null) {
                                    lVar7.abZ();
                                }
                            }
                        }
                        h hVar = cVar.gVb;
                        if (hVar != null) {
                            i2 = hVar.dXA();
                        } else {
                            i2 = 1;
                        }
                        h hVar2 = cVar.gVb;
                        if (hVar2 != null) {
                            hVar2.OH(i2);
                        }
                        h hVar3 = cVar.gVb;
                        if (hVar3 != null) {
                            hVar3.rU();
                        }
                        h hVar4 = cVar.gVb;
                        if (hVar4 != null) {
                            hVar4.pause();
                        }
                        z = true;
                    } else {
                        f.a aVar8 = f.gVz;
                        f.a.auz();
                        z = false;
                    }
                } else {
                    Log.i(TAG, "setPlayingKey: no config");
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.g.b.a.l lVar8 = cVar.gVi;
                    if (lVar8 != null) {
                        lVar8.jC(2);
                    }
                    com.tencent.mm.g.b.a.l lVar9 = cVar.gVi;
                    if (lVar9 != null) {
                        lVar9.bfK();
                    }
                    this.gVq.b(cVar);
                } else {
                    com.tencent.mm.g.b.a.l lVar10 = cVar.gVi;
                    if (lVar10 != null) {
                        lVar10.jC(1);
                    }
                }
            }
            AppMethodBeat.o(199889);
        }
        return false;
    }

    public final void onStop() {
        AppMethodBeat.i(199890);
        Log.i(TAG, "onStop: " + this.gVq.gVo.size());
        Iterator<T> it = this.gVq.gVo.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.gVq.gVo.clear();
        AppMethodBeat.o(199890);
    }

    public final void a(a aVar) {
        boolean b2;
        b.C0317b bVar;
        MMAnimateView mMAnimateView;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        AppMethodBeat.i(199891);
        p.h(aVar, "viewProvider");
        if (this.gVq.gVo.size() > 0 && (frameLayout2 = this.gUY) != null) {
            frameLayout2.getLocationInWindow(this.uBR);
        }
        ArrayList<c> arrayList = new ArrayList();
        for (T t : this.gVq.gVo) {
            View zh = aVar.zh(t.msgId);
            if (zh != null) {
                boolean b3 = t.b(aVar.ck(zh));
                int[] iArr = this.uBR;
                p.h(iArr, "rootLocation");
                MMNeat7extView mMNeat7extView = t.gVa;
                com.tencent.neattextview.textview.layout.a layout = mMNeat7extView != null ? mMNeat7extView.getLayout() : null;
                if (layout != null) {
                    int lineWidth = (int) layout.getLineWidth(0);
                    a.C0316a aVar2 = a.gUT;
                    PointF a2 = a.C0316a.a(mMNeat7extView);
                    int[] iArr2 = new int[2];
                    mMNeat7extView.getLocationInWindow(iArr2);
                    int i2 = iArr2[1] - iArr[1];
                    float f2 = ((float) (iArr2[0] - iArr[0])) + a2.x;
                    float f3 = a2.y + ((float) i2);
                    if (t.gVb == null) {
                        Log.i(t.TAG, "updateView: no drawable");
                        b2 = b3;
                    } else if (t.gUY == null) {
                        Log.i(t.TAG, "updateView: no rootView");
                        b2 = b3;
                    } else {
                        if (t.gUZ == null) {
                            FrameLayout frameLayout3 = t.gUY;
                            t.gUZ = new MMAnimateView(frameLayout3 != null ? frameLayout3.getContext() : null);
                            FrameLayout frameLayout4 = t.gUY;
                            if (frameLayout4 != null) {
                                frameLayout4.addView(t.gUZ, new FrameLayout.LayoutParams(lineWidth, lineWidth));
                            }
                            MMAnimateView mMAnimateView2 = t.gUZ;
                            if (mMAnimateView2 != null) {
                                mMAnimateView2.setVisibility(8);
                            }
                        }
                        MMAnimateView mMAnimateView3 = t.gUZ;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) (mMAnimateView3 != null ? mMAnimateView3.getLayoutParams() : null);
                        if (layoutParams == null) {
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(lineWidth, lineWidth);
                            MMAnimateView mMAnimateView4 = t.gUZ;
                            if (mMAnimateView4 != null) {
                                mMAnimateView4.setLayoutParams(layoutParams2);
                            }
                        } else if (!(layoutParams.width == lineWidth && layoutParams.height == lineWidth)) {
                            layoutParams.width = lineWidth;
                            layoutParams.height = lineWidth;
                            MMAnimateView mMAnimateView5 = t.gUZ;
                            if (mMAnimateView5 != null) {
                                mMAnimateView5.setLayoutParams(layoutParams);
                            }
                        }
                        MMAnimateView mMAnimateView6 = t.gUZ;
                        if (mMAnimateView6 != null) {
                            mMAnimateView6.setTranslationX(f2 - ((float) (lineWidth / 2)));
                        }
                        MMAnimateView mMAnimateView7 = t.gUZ;
                        if (mMAnimateView7 != null) {
                            mMAnimateView7.setTranslationY(f3 - ((float) (lineWidth / 2)));
                        }
                        if (!t.gVd) {
                            com.tencent.mm.g.b.a.l lVar = t.gVi;
                            if (lVar != null) {
                                lVar.bfK();
                            }
                            FrameLayout frameLayout5 = t.gUY;
                            if (!(frameLayout5 == null || frameLayout5.getVisibility() != 8 || (frameLayout = t.gUY) == null)) {
                                frameLayout.setVisibility(0);
                            }
                            MMAnimateView mMAnimateView8 = t.gUZ;
                            if (!(mMAnimateView8 == null || mMAnimateView8.getVisibility() != 8 || (mMAnimateView = t.gUZ) == null)) {
                                mMAnimateView.setVisibility(0);
                            }
                            MMAnimateView mMAnimateView9 = t.gUZ;
                            if (mMAnimateView9 != null) {
                                mMAnimateView9.setImageDrawable(t.gVb);
                            }
                            d.C(t.gVg);
                            b.a aVar3 = t.gVc;
                            if (!(aVar3 == null || (bVar = aVar3.gUX) == null || bVar.delay < 0)) {
                                d.a((long) bVar.delay, t.gVg);
                            }
                            t.gVd = true;
                            d.C(t.gVh);
                            MMAnimateView mMAnimateView10 = t.gUZ;
                            if (mMAnimateView10 != null) {
                                mMAnimateView10.animate().scaleX(1.5f).scaleY(1.5f).setDuration(0).withEndAction(new c.d(mMAnimateView10, t));
                                b2 = b3;
                            }
                        }
                        b2 = b3;
                    }
                } else {
                    Log.i(t.TAG, "updateView: no layout");
                    b2 = b3;
                }
            } else {
                b2 = t.b(null);
            }
            if (b2) {
                arrayList.add(t);
            }
        }
        for (c cVar : arrayList) {
            this.gVq.b(cVar);
        }
        AppMethodBeat.o(199891);
    }
}
