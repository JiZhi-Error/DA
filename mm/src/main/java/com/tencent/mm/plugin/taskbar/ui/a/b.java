package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundManager;", "", "()V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "context", "Landroid/content/Context;", "plugin-taskbar_release"})
public final class b {
    public static final b FVa = new b();

    static {
        AppMethodBeat.i(238471);
        AppMethodBeat.o(238471);
    }

    private b() {
    }

    public static void init(Context context) {
        AppMethodBeat.i(238470);
        p.h(context, "context");
        com.tencent.mm.dynamicbackground.a.b bVar = com.tencent.mm.dynamicbackground.a.b.gRt;
        p.h(context, "context");
        File file = new File(com.tencent.mm.dynamicbackground.a.b.cF(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        com.tencent.mm.dynamicbackground.a.b.j(context, "scene_shaderf.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "scene_shaderf.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "scene_shaderv.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "scene_shaderv.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "frag_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "frag_framebuffer_plane.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "vertex_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "vertex_framebuffer_plane.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "texture_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "texture_vertex_shader.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "texture_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "texture_fragment_shader.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "bg_gradient_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "bg_gradient_vertex_shader.glsl");
        com.tencent.mm.dynamicbackground.a.b.j(context, "bg_gradient_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(context) + "bg_gradient_fragment_shader.glsl");
        AppMethodBeat.o(238470);
    }
}
