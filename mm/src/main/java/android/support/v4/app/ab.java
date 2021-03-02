package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab implements Iterable<Intent> {
    public final ArrayList<Intent> IS = new ArrayList<>();
    public final Context IT;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private ab(Context context) {
        this.IT = context;
    }

    public static ab R(Context context) {
        return new ab(context);
    }

    public final ab a(ComponentName componentName) {
        int size = this.IS.size();
        try {
            Intent a2 = q.a(this.IT, componentName);
            while (a2 != null) {
                this.IS.add(size, a2);
                a2 = q.a(this.IT, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.IS.iterator();
    }
}
