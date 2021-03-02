package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.s;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class u {
    private static final Object Ip = new Object();
    private static Field Iq;
    private static boolean Ir;
    private static final Object Is = new Object();

    public static SparseArray<Bundle> h(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (Ip) {
            if (Ir) {
                return null;
            }
            try {
                if (Iq == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Ir = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    Iq = declaredField;
                }
                Bundle bundle = (Bundle) Iq.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    Iq.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                Ir = true;
                return null;
            }
        }
    }

    static Bundle c(s.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.icon);
        bundle2.putCharSequence("title", aVar.title);
        bundle2.putParcelable("actionIntent", aVar.actionIntent);
        if (aVar.mExtras != null) {
            bundle = new Bundle(aVar.mExtras);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.Hj);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.Hh));
        bundle2.putBoolean("showsUserInterface", aVar.Hk);
        bundle2.putInt("semanticAction", aVar.Hl);
        return bundle2;
    }

    private static Bundle[] a(x[] xVarArr) {
        if (xVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[xVarArr.length];
        for (int i2 = 0; i2 < xVarArr.length; i2++) {
            x xVar = xVarArr[i2];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", xVar.II);
            bundle.putCharSequence("label", xVar.IJ);
            bundle.putCharSequenceArray("choices", xVar.IK);
            bundle.putBoolean("allowFreeFormInput", xVar.IL);
            bundle.putBundle("extras", xVar.mExtras);
            Set<String> set = xVar.IM;
            if (set != null && !set.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(set.size());
                for (String str : set) {
                    arrayList.add(str);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i2] = bundle;
        }
        return bundleArr;
    }

    public static Bundle a(Notification.Builder builder, s.a aVar) {
        builder.addAction(aVar.icon, aVar.title, aVar.actionIntent);
        Bundle bundle = new Bundle(aVar.mExtras);
        if (aVar.Hh != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.Hh));
        }
        if (aVar.Hi != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.Hi));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.Hj);
        return bundle;
    }
}
