package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.g.c;
import com.tencent.matrix.resource.b.a;
import java.lang.reflect.Field;

public class b extends com.tencent.matrix.e.b {
    public final a cWP;
    public com.tencent.matrix.resource.e.b cWQ = null;

    public b(a aVar) {
        this.cWP = aVar;
    }

    public static void b(Application application) {
        application.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.e.a() {
            /* class com.tencent.matrix.resource.b.AnonymousClass1 */

            @Override // com.tencent.matrix.resource.e.a
            public final void onActivityDestroyed(Activity activity) {
                InputMethodManager inputMethodManager;
                long currentTimeMillis = System.currentTimeMillis();
                if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
                    String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 3) {
                            break;
                        }
                        try {
                            Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                            if (!declaredField.isAccessible()) {
                                declaredField.setAccessible(true);
                            }
                            Object obj = declaredField.get(inputMethodManager);
                            if (obj instanceof View) {
                                View view = (View) obj;
                                if (view.getContext() != activity) {
                                    c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + activity, new Object[0]);
                                    break;
                                }
                                declaredField.set(inputMethodManager, null);
                            } else {
                                continue;
                            }
                        } catch (Throwable th) {
                            c.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", th.toString());
                        }
                        i2++;
                    }
                }
                c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                if (activity == null || activity.getWindow() == null || activity.getWindow().peekDecorView() == null) {
                    c.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
                } else {
                    View rootView = activity.getWindow().peekDecorView().getRootView();
                    try {
                        a.ch(rootView);
                        if (rootView instanceof ViewGroup) {
                            ((ViewGroup) rootView).removeAllViews();
                        }
                    } catch (Throwable th2) {
                        c.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", th2);
                    }
                }
                c.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
        });
    }

    @Override // com.tencent.matrix.e.b
    public void init(Application application, com.tencent.matrix.e.c cVar) {
        super.init(application, cVar);
        if (Build.VERSION.SDK_INT < 14) {
            c.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.cWQ = new com.tencent.matrix.resource.e.b(application, this);
    }

    @Override // com.tencent.matrix.e.b
    public void start() {
        super.start();
        if (!isSupported()) {
            c.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
            return;
        }
        com.tencent.matrix.resource.e.b bVar = this.cWQ;
        bVar.Tf();
        Application application = bVar.cZD.getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(bVar.cZN);
            com.tencent.matrix.a.INSTANCE.a(bVar);
            bVar.cZE.a(bVar.cZO, 0);
            c.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
        }
    }

    @Override // com.tencent.matrix.e.b
    public void stop() {
        super.stop();
        if (!isSupported()) {
            c.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
            return;
        }
        this.cWQ.Tf();
        c.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
    }

    @Override // com.tencent.matrix.e.b
    public void destroy() {
        super.destroy();
        if (!isSupported()) {
            c.e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
            return;
        }
        this.cWQ.cZE.Tm();
        c.i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
    }

    @Override // com.tencent.matrix.e.b
    public String getTag() {
        return "memory";
    }
}
