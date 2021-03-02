package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* access modifiers changed from: package-private */
public interface d {
    void a(int i2, int i3, Rect rect);

    void init(int i2, int i3);

    void reset();

    public static class b {
        public int x;
        public int y;
        public int z;

        public final b im(int i2) {
            this.x = 1;
            this.y = 1;
            this.z = i2;
            return this;
        }

        public final String toString() {
            AppMethodBeat.i(140010);
            String str = "[" + this.x + ", " + this.y + ", " + this.z + "]";
            AppMethodBeat.o(140010);
            return str;
        }
    }

    public static class c {
        public int height;
        public int width;
        public int x;
        public int y;

        public final String toString() {
            AppMethodBeat.i(140011);
            String str = "[" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + "]";
            AppMethodBeat.o(140011);
            return str;
        }
    }

    public static class a {
        public Queue<b> aIT = new LinkedList();

        public a() {
            AppMethodBeat.i(140006);
            AppMethodBeat.o(140006);
        }

        public final b Ry() {
            AppMethodBeat.i(140007);
            b poll = this.aIT.poll();
            if (poll == null) {
                b bVar = new b();
                AppMethodBeat.o(140007);
                return bVar;
            }
            AppMethodBeat.o(140007);
            return poll;
        }

        public final void a(b bVar) {
            AppMethodBeat.i(140008);
            this.aIT.offer(bVar);
            AppMethodBeat.o(140008);
        }

        public final void e(ArrayList<b> arrayList) {
            AppMethodBeat.i(140009);
            if (arrayList == null || arrayList.isEmpty()) {
                AppMethodBeat.o(140009);
                return;
            }
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                this.aIT.offer(it.next());
            }
            arrayList.clear();
            AppMethodBeat.o(140009);
        }
    }
}
