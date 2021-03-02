package com.tencent.matrix.e;

import android.app.Application;
import com.tencent.matrix.a;
import com.tencent.matrix.b.c;
import com.tencent.matrix.report.d;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b implements c, d.a {
    public static final int PLUGIN_CREATE = 0;
    public static final int PLUGIN_DESTROYED = 8;
    public static final int PLUGIN_INITED = 1;
    public static final int PLUGIN_STARTED = 2;
    public static final int PLUGIN_STOPPED = 4;
    private static final String TAG = "Matrix.Plugin";
    private Application application;
    private boolean isSupported = true;
    private c pluginListener;
    private int status = 0;

    public void init(Application application2, c cVar) {
        if (this.application == null && this.pluginListener == null) {
            this.status = 1;
            this.application = application2;
            this.pluginListener = cVar;
            a.INSTANCE.a(this);
            return;
        }
        throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }

    public Application getApplication() {
        return this.application;
    }

    public void start() {
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin start, but plugin has been already destroyed");
        } else if (isPluginStarted()) {
            throw new RuntimeException("plugin start, but plugin has been already started");
        } else {
            this.status = 2;
            if (this.pluginListener == null) {
                throw new RuntimeException("plugin start, plugin listener is null");
            }
            this.pluginListener.c(this);
        }
    }

    public void stop() {
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin stop, but plugin has been already destroyed");
        } else if (!isPluginStarted()) {
            throw new RuntimeException("plugin stop, but plugin is never started");
        } else {
            this.status = 4;
            if (this.pluginListener == null) {
                throw new RuntimeException("plugin stop, plugin listener is null");
            }
            this.pluginListener.d(this);
        }
    }

    public void destroy() {
        if (isPluginStarted()) {
            stop();
        }
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin destroy, but plugin has been already destroyed");
        }
        this.status = 8;
        if (this.pluginListener == null) {
            throw new RuntimeException("plugin destroy, plugin listener is null");
        }
        this.pluginListener.e(this);
    }

    public String getTag() {
        return getClass().getName();
    }

    @Override // com.tencent.matrix.b.c
    public void onForeground(boolean z) {
    }

    public boolean isForeground() {
        return a.INSTANCE.cPB;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isPluginStarted() {
        return this.status == 2;
    }

    public boolean isPluginStopped() {
        return this.status == 4;
    }

    public boolean isPluginDestroyed() {
        return this.status == 8;
    }

    public boolean isSupported() {
        return this.isSupported;
    }

    public void unSupportPlugin() {
        this.isSupported = false;
    }

    public JSONObject getJsonInfo() {
        return new JSONObject();
    }

    @Override // com.tencent.matrix.report.d.a
    public void onDetectIssue(com.tencent.matrix.report.c cVar) {
        if (cVar.tag == null) {
            cVar.tag = getTag();
        }
        cVar.cWf = this;
        JSONObject jSONObject = cVar.cWe;
        try {
            if (cVar.tag != null) {
                jSONObject.put("tag", cVar.tag);
            }
            if (cVar.type != 0) {
                jSONObject.put("type", cVar.type);
            }
            jSONObject.put("process", com.tencent.matrix.g.d.getProcessName(this.application));
            jSONObject.put("time", System.currentTimeMillis());
        } catch (JSONException e2) {
            com.tencent.matrix.g.c.e(TAG, "json error", e2);
        }
        this.pluginListener.a(cVar);
    }
}
