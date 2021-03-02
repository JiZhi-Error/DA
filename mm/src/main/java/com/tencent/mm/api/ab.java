package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ab {
    public static b diQ;
    protected a diP;

    public interface b {
        ab Uo();
    }

    public abstract boolean Ul();

    public abstract x Um();

    public abstract void a(u uVar);

    public abstract e bB(Context context);

    public abstract void onDestroy();

    public enum c {
        diY,
        PHOTO,
        SCREEN;

        public static c valueOf(String str) {
            AppMethodBeat.i(149430);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(149430);
            return cVar;
        }

        static {
            AppMethodBeat.i(149431);
            AppMethodBeat.o(149431);
        }
    }

    public void a(a aVar) {
        this.diP = aVar;
    }

    public void Un() {
    }

    public static class a {
        public int backgroundColor;
        public c diR;
        public boolean diS;
        public boolean diT;
        public boolean diU;
        public Rect diV;
        public String path;
        public Rect rect;

        public a(String str, c cVar, boolean z, boolean z2, Rect rect2, boolean z3, Rect rect3, int i2) {
            this.diR = cVar;
            this.path = str;
            this.diS = z;
            this.diT = z2;
            this.rect = rect2;
            this.diU = z3;
            this.diV = rect3;
            this.backgroundColor = i2;
        }

        /* renamed from: com.tencent.mm.api.ab$a$a  reason: collision with other inner class name */
        public static class C0260a {
            int backgroundColor;
            public c diR;
            public boolean diS;
            boolean diU = false;
            Rect diV;
            public boolean diW = true;
            public Rect diX;
            public String path;

            public final C0260a VH() {
                this.diW = false;
                return this;
            }

            public final C0260a fN(String str) {
                this.path = str;
                return this;
            }

            public final C0260a i(Rect rect) {
                this.diV = rect;
                return this;
            }

            public final C0260a a(c cVar) {
                this.diR = cVar;
                return this;
            }

            public final C0260a cJ(boolean z) {
                this.diS = z;
                return this;
            }

            public final C0260a j(Rect rect) {
                this.diX = rect;
                return this;
            }

            public final C0260a cK(boolean z) {
                this.diU = z;
                return this;
            }

            public final C0260a VI() {
                this.backgroundColor = 0;
                return this;
            }

            public final a VJ() {
                AppMethodBeat.i(149428);
                a aVar = new a(this.path, this.diR, this.diS, this.diW, this.diX, this.diU, this.diV, this.backgroundColor);
                AppMethodBeat.o(149428);
                return aVar;
            }
        }
    }
}
