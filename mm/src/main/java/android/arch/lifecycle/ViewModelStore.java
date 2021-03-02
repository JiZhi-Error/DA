package android.arch.lifecycle;

import java.util.HashMap;

public class ViewModelStore {
    public final HashMap<String, ViewModel> mMap = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, ViewModel viewModel) {
        ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }

    public final void clear() {
        for (ViewModel viewModel : this.mMap.values()) {
            viewModel.onCleared();
        }
        this.mMap.clear();
    }
}
