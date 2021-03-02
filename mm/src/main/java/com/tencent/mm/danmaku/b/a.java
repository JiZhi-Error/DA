package com.tencent.mm.danmaku.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import com.tencent.mm.danmaku.c.i;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.e;
import com.tencent.mm.danmaku.d.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<DATA, CONFIG extends i> {
    private static final AtomicInteger gOJ = new AtomicInteger();
    protected com.tencent.mm.danmaku.c.a gNt;
    protected long gOK;
    protected e gOL;
    protected final PriorityQueue<b> gOM;
    protected int gON;
    protected int gOO;
    protected float gOP = -1.0f;
    protected float gOQ = -1.0f;
    protected float gOR;
    protected boolean gOS;
    protected Bitmap gOT;
    protected Canvas gOU;
    protected int gOV;
    protected int gOW = -1;
    protected int gOX;
    protected boolean gOY;
    protected boolean gOZ = false;
    protected AbstractC0310a gPa;
    public float gPb = -1.0f;
    public float gPc = -1.0f;
    public volatile boolean gPd = true;
    public volatile boolean gPe = true;
    protected CONFIG gPf;
    private HashMap<String, Object> gPg;
    public DATA mData;
    protected final int mIndex = gOJ.incrementAndGet();
    protected boolean mIsPaused;
    protected long mTime;
    protected int mVisibility;

    /* renamed from: com.tencent.mm.danmaku.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0310a {
    }

    public abstract void a(float f2, long j2, long j3);

    public abstract float asv();

    public abstract float getBottom();

    public abstract float getLeft();

    public abstract float getRight();

    public abstract float getTop();

    public abstract int getType();

    public abstract void zb(long j2);

    public abstract float[] zc(long j2);

    public abstract float[] zd(long j2);

    public static final class b implements Comparable<b> {
        public long gPh;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            if (bVar2 == null) {
                return 1;
            }
            if (this.gPh > bVar2.gPh) {
                return -1;
            }
            if (this.gPh >= bVar2.gPh) {
                return 0;
            }
            return 1;
        }

        public final String toString() {
            AppMethodBeat.i(241677);
            String str = "mRemainTime:" + this.gPh;
            AppMethodBeat.o(241677);
            return str;
        }
    }

    public a(com.tencent.mm.danmaku.c.a aVar) {
        this.gNt = aVar;
        this.gOM = new PriorityQueue<>();
        try {
            this.gPf = (CONFIG) this.gNt.oZ(getType());
        } catch (Exception e2) {
            if (c.gNA) {
                throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext");
            }
        }
        reset();
    }

    public final void asu() {
        this.gOL = new e((long) com.tencent.mm.danmaku.c.a.asO().atU);
    }

    public final boolean isPaused() {
        return this.mIsPaused;
    }

    public void reset() {
        m asO = com.tencent.mm.danmaku.c.a.asO();
        this.gOR = asO.gOR;
        this.gOS = asO.gOS;
        this.gOM.clear();
        this.gON = 0;
        this.gOO = 0;
        this.gOP = -1.0f;
        this.gOQ = -1.0f;
        this.mVisibility = 0;
        this.gOT = null;
        this.gOV = 0;
        this.gOX = 0;
        this.mIsPaused = false;
        this.gOZ = false;
        this.gPd = true;
        this.gPe = true;
        this.gPb = -1.0f;
        this.gPc = -1.0f;
        if (this.gPg != null) {
            Iterator<Object> it = this.gPg.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.gPg.clear();
            this.gPg = null;
        }
        asu();
    }

    public final long asw() {
        return this.gOK + this.gOL.mValue;
    }

    public final void aj(float f2) {
        e eVar = this.gOL;
        eVar.mValue = (long) (((float) eVar.mValue) * f2);
    }

    public final void ako() {
        float left = getLeft();
        if (!this.gOZ && left < ((float) com.tencent.mm.danmaku.c.a.asO().mScreenWidth)) {
            com.tencent.mm.danmaku.e.e.d("BaseDanmaku", "onFirstExposure, danmaku = " + toString());
            this.gOZ = true;
        }
        if (this.gPa != null && left <= 0.0f) {
            this.gPa = null;
        }
    }

    public final boolean asx() {
        return this.gOP >= 0.0f && this.gOQ >= 0.0f && !this.gPd;
    }

    public final boolean isShown() {
        return this.mVisibility == 1;
    }

    public final boolean yY(long j2) {
        if (!this.gOY && j2 - this.mTime >= this.gOL.mValue) {
            return true;
        }
        return false;
    }

    public final boolean yZ(long j2) {
        return this.gOK > 0 && j2 - this.gOK >= this.gOL.mValue;
    }

    public final boolean za(long j2) {
        return this.gOK > 0 && j2 - this.gOK < 0;
    }

    public final void setVisibility(boolean z) {
        if (z) {
            this.mVisibility = 1;
        } else {
            this.mVisibility = 0;
        }
    }

    public final void x(long j2, long j3) {
        if (this.mIsPaused) {
            this.gOK += j2;
        }
        zb(j3);
        if (!this.gOM.isEmpty()) {
            Iterator<b> it = this.gOM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.gPh -= j2;
                if (next.gPh <= 0) {
                    it.remove();
                }
            }
        }
    }

    public final DATA getData() {
        return this.mData;
    }

    public int hashCode() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.mData != null) {
            return this.mData.equals(aVar.mData);
        }
        return aVar.mData == null;
    }

    public String toString() {
        return "BaseDanmaku" + this.mIndex + "[left:" + getLeft() + ",top:" + getTop() + ",right:" + getRight() + ",bottom:" + getBottom() + ", time:" + this.mTime + ", mData=" + String.valueOf(this.mData) + "mType=" + getType() + "]";
    }

    public final long adU() {
        return (long) this.mIndex;
    }

    public final long getTime() {
        return this.mTime;
    }

    public final void setTime(long j2) {
        this.mTime = j2;
    }

    public final int asz() {
        return this.gON;
    }

    public final int asA() {
        return this.gOO;
    }

    public final float asB() {
        return this.gOP;
    }

    public final void ak(float f2) {
        this.gOP = f2;
    }

    public final float asC() {
        return this.gOQ;
    }

    public final void al(float f2) {
        this.gOQ = f2;
    }

    public final int asD() {
        return this.gOV;
    }

    public final void asE() {
        this.gOV = 3000;
    }

    public static boolean asF() {
        return com.tencent.mm.danmaku.c.a.asO().gPL;
    }

    public final float asG() {
        return getLeft() + ((float) com.tencent.mm.danmaku.c.a.asO().gPJ);
    }

    public final float asH() {
        return getTop() + ((float) com.tencent.mm.danmaku.c.a.asO().gPI);
    }

    public static int getScreenWidth() {
        return com.tencent.mm.danmaku.c.a.asO().mScreenWidth;
    }

    public static int getScreenHeight() {
        return com.tencent.mm.danmaku.c.a.asO().mScreenHeight;
    }

    public final boolean asI() {
        return this.gOS && m.asY();
    }

    public final Bitmap asJ() {
        return this.gOT;
    }

    public final void w(Bitmap bitmap) {
        this.gOT = bitmap;
    }

    public final Canvas asK() {
        return this.gOU;
    }

    public final void m(Canvas canvas) {
        this.gOU = canvas;
        this.gPe = true;
    }

    public final void asL() {
        this.gOU.setBitmap(null);
    }

    public final int oX(int i2) {
        return this.gOX > i2 ? i2 - 1 : this.gOX;
    }

    public final int oY(int i2) {
        return this.gOW >= i2 ? i2 - 1 : this.gOW;
    }

    public final boolean asM() {
        return this.gOY;
    }

    public final void ze(long j2) {
        this.gOK = j2;
    }

    public final long asN() {
        return this.gOK;
    }

    public com.tencent.mm.danmaku.d.b b(h hVar) {
        return new com.tencent.mm.danmaku.d.b(-1);
    }

    public void asy() {
        this.gPd = false;
    }

    public final boolean oW(int i2) {
        if (!this.gOY && this.gOV - i2 < 0) {
            return false;
        }
        this.gOV -= i2;
        this.gOK += (long) i2;
        return true;
    }
}
