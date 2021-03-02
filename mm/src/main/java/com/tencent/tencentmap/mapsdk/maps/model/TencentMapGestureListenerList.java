package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TencentMapGestureListenerList implements TencentMapGestureListener {
    private ArrayList<TencentMapGestureListener> mListeners = new ArrayList<>();

    public TencentMapGestureListenerList() {
        AppMethodBeat.i(173376);
        AppMethodBeat.o(173376);
    }

    public synchronized void addListener(TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(173377);
        if (tencentMapGestureListener != null && !this.mListeners.contains(tencentMapGestureListener)) {
            this.mListeners.add(tencentMapGestureListener);
        }
        AppMethodBeat.o(173377);
    }

    public synchronized void removeListener(TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(173378);
        this.mListeners.remove(tencentMapGestureListener);
        AppMethodBeat.o(173378);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onDoubleTap(float f2, float f3) {
        AppMethodBeat.i(173379);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onDoubleTap(f2, f3);
        }
        AppMethodBeat.o(173379);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onSingleTap(float f2, float f3) {
        AppMethodBeat.i(173380);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onSingleTap(f2, f3);
        }
        AppMethodBeat.o(173380);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onFling(float f2, float f3) {
        AppMethodBeat.i(173381);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onFling(f2, f3);
        }
        AppMethodBeat.o(173381);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onScroll(float f2, float f3) {
        AppMethodBeat.i(173382);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onScroll(f2, f3);
        }
        AppMethodBeat.o(173382);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onLongPress(float f2, float f3) {
        AppMethodBeat.i(173383);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onLongPress(f2, f3);
        }
        AppMethodBeat.o(173383);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onDown(float f2, float f3) {
        AppMethodBeat.i(173384);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onDown(f2, f3);
        }
        AppMethodBeat.o(173384);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized boolean onUp(float f2, float f3) {
        AppMethodBeat.i(173385);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onUp(f2, f3);
        }
        AppMethodBeat.o(173385);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public synchronized void onMapStable() {
        AppMethodBeat.i(173386);
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onMapStable();
        }
        AppMethodBeat.o(173386);
    }
}
