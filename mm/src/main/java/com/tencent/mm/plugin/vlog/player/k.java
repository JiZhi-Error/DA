package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.tencent.mm.media.g.d;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H&J6\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0016H&J\u0006\u0010\u001e\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160!H&J\b\u0010\"\u001a\u00020\u0016H&J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u0016H&R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "", "width", "", "height", "(II)V", "consumer", "Landroid/view/Surface;", "getConsumer", "()Landroid/view/Surface;", "setConsumer", "(Landroid/view/Surface;)V", "getHeight", "()I", "productionTexObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getProductionTexObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setProductionTexObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "getWidth", "attachConsumer", "", "surface", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "getProductionTex", "queueEvent", "task", "Lkotlin/Function0;", "release", "submitProduction", "ptsMS", "", "unbindPreloadConsumer", "plugin-vlog_release"})
public abstract class k {
    d GCg;
    Surface GCh;
    final int height;
    final int width;

    public abstract void KY(long j2);

    public abstract void a(EGLContext eGLContext, EGLDisplay eGLDisplay, Surface surface, int i2, int i3);

    public abstract void clearTask();

    public abstract void fCo();

    public abstract void j(a<x> aVar);

    public abstract void k(Surface surface);

    public abstract void release();

    public k(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public final int fCq() {
        d dVar = this.GCg;
        if (dVar != null) {
            return dVar.igv;
        }
        return -1;
    }
}
