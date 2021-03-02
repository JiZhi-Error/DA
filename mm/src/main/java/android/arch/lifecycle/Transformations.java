package android.arch.lifecycle;

import android.arch.a.c.a;

public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> liveData, final a<X, Y> aVar) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            /* class android.arch.lifecycle.Transformations.AnonymousClass1 */

            @Override // android.arch.lifecycle.Observer
            public final void onChanged(X x) {
                mediatorLiveData.setValue(aVar.apply(x));
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final a<X, LiveData<Y>> aVar) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            /* class android.arch.lifecycle.Transformations.AnonymousClass2 */
            LiveData<Y> dv;

            @Override // android.arch.lifecycle.Observer
            public final void onChanged(X x) {
                LiveData<Y> liveData = (LiveData) aVar.apply(x);
                if (this.dv != liveData) {
                    if (this.dv != null) {
                        mediatorLiveData.removeSource(this.dv);
                    }
                    this.dv = liveData;
                    if (this.dv != null) {
                        mediatorLiveData.addSource(this.dv, new Observer<Y>() {
                            /* class android.arch.lifecycle.Transformations.AnonymousClass2.AnonymousClass1 */

                            @Override // android.arch.lifecycle.Observer
                            public void onChanged(Y y) {
                                mediatorLiveData.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return mediatorLiveData;
    }
}
