package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})
    private Application ca;

    public AndroidViewModel(Application application) {
        this.ca = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.ca;
    }
}
