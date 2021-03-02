package android.arch.lifecycle;

import android.arch.a.b.b;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private b<LiveData<?>, Source<?>> cZ = new b<>();

    public <S> void addSource(LiveData<S> liveData, Observer<S> observer) {
        Source<?> source = new Source<>(liveData, observer);
        Source<?> putIfAbsent = this.cZ.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.cX != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (putIfAbsent == null && hasActiveObservers()) {
            source.af();
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source<?> remove = this.cZ.remove(liveData);
        if (remove != null) {
            remove.am();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.LiveData
    public final void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.cZ.iterator();
        while (it.hasNext()) {
            it.next().getValue().af();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.LiveData
    public final void Z() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.cZ.iterator();
        while (it.hasNext()) {
            it.next().getValue().am();
        }
    }

    static class Source<V> implements Observer<V> {
        int cR = -1;
        final Observer<V> cX;
        final LiveData<V> ci;

        Source(LiveData<V> liveData, Observer<V> observer) {
            this.ci = liveData;
            this.cX = observer;
        }

        /* access modifiers changed from: package-private */
        public final void af() {
            this.ci.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        public final void am() {
            this.ci.removeObserver(this);
        }

        @Override // android.arch.lifecycle.Observer
        public void onChanged(V v) {
            if (this.cR != this.ci.cR) {
                this.cR = this.ci.cR;
                this.cX.onChanged(v);
            }
        }
    }
}
