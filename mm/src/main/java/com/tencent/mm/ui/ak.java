package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

public final class ak extends TouchDelegate {
    private static final Rect OLB = new Rect();
    public ArrayList<al> OLC;
    public al OLD;

    static {
        AppMethodBeat.i(205133);
        AppMethodBeat.o(205133);
    }

    public ak(View view) {
        super(OLB, view);
    }

    public final void a(al alVar) {
        AppMethodBeat.i(205130);
        if (this.OLC == null) {
            this.OLC = new ArrayList<>();
        }
        this.OLC.add(alVar);
        AppMethodBeat.o(205130);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        al alVar = null;
        AppMethodBeat.i(205131);
        switch (motionEvent.getAction()) {
            case 0:
                if (this.OLC != null) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    Iterator<al> it = this.OLC.iterator();
                    ArrayList arrayList = null;
                    while (it.hasNext()) {
                        al next = it.next();
                        motionEvent.setLocation(x, y);
                        if (next != null && next.onTouchEvent(motionEvent)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(next);
                        }
                    }
                    motionEvent.setLocation(x, y);
                    al a2 = a(arrayList, motionEvent);
                    if (a2 != null) {
                        this.OLD = a2;
                        AppMethodBeat.o(205131);
                        return true;
                    }
                }
                break;
            case 1:
            case 3:
                al alVar2 = this.OLD;
                this.OLD = null;
                alVar = alVar2;
                break;
            case 2:
                alVar = this.OLD;
                break;
        }
        if (alVar == null) {
            AppMethodBeat.o(205131);
            return false;
        }
        boolean onTouchEvent = alVar.onTouchEvent(motionEvent);
        AppMethodBeat.o(205131);
        return onTouchEvent;
    }

    private static al a(ArrayList<al> arrayList, MotionEvent motionEvent) {
        AppMethodBeat.i(205132);
        if (arrayList == null) {
            AppMethodBeat.o(205132);
            return null;
        }
        int size = arrayList.size();
        if (size <= 0) {
            AppMethodBeat.o(205132);
            return null;
        } else if (size == 1) {
            al alVar = arrayList.get(0);
            AppMethodBeat.o(205132);
            return alVar;
        } else {
            int i2 = Integer.MAX_VALUE;
            al alVar2 = null;
            int i3 = 0;
            while (i3 < size) {
                al alVar3 = arrayList.get(i3);
                p.h(motionEvent, "event");
                int[] iArr = new int[2];
                alVar3.OLE.getLocationOnScreen(iArr);
                int sqrt = (int) Math.sqrt(Math.pow((double) (motionEvent.getRawX() - ((float) (iArr[0] + (alVar3.OLE.getWidth() / 2)))), 2.0d) + Math.pow((double) (motionEvent.getRawY() - ((float) (iArr[1] + (alVar3.OLE.getHeight() / 2)))), 2.0d));
                if (sqrt >= i2) {
                    alVar3 = alVar2;
                    sqrt = i2;
                }
                i3++;
                alVar2 = alVar3;
                i2 = sqrt;
            }
            if (i2 == Integer.MAX_VALUE) {
                al alVar4 = arrayList.get(0);
                AppMethodBeat.o(205132);
                return alVar4;
            }
            AppMethodBeat.o(205132);
            return alVar2;
        }
    }
}
