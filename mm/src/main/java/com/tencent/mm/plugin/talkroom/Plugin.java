package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class Plugin implements d {
    public Plugin() {
        AppMethodBeat.i(29370);
        EventCenter.instance.addListener(new IListener<ma>() {
            /* class com.tencent.mm.plugin.talkroom.Plugin.AnonymousClass1 */

            {
                AppMethodBeat.i(161451);
                this.__eventId = ma.class.getName().hashCode();
                AppMethodBeat.o(161451);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ma maVar) {
                AppMethodBeat.i(29366);
                switch (maVar.dRA.status) {
                    case 0:
                        if (com.tencent.mm.plugin.talkroom.model.b.ftN() != null) {
                            com.tencent.mm.plugin.talkroom.model.b.ftN().fub();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(29366);
                return false;
            }
        });
        EventCenter.instance.addListener(new b((byte) 0));
        EventCenter.instance.addListener(new a(this, (byte) 0));
        EventCenter.instance.addListener(new c(this, (byte) 0));
        AppMethodBeat.o(29370);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(29371);
        a aVar = new a();
        AppMethodBeat.o(29371);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public com.tencent.mm.pluginsdk.b.c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(29372);
        com.tencent.mm.plugin.talkroom.model.b bVar = new com.tencent.mm.plugin.talkroom.model.b();
        AppMethodBeat.o(29372);
        return bVar;
    }

    static class b extends IListener<xq> {
        private b() {
            AppMethodBeat.i(161454);
            this.__eventId = xq.class.getName().hashCode();
            AppMethodBeat.o(161454);
        }

        /* synthetic */ b(byte b2) {
            this();
            AppMethodBeat.i(161455);
            this.__eventId = xq.class.getName().hashCode();
            AppMethodBeat.o(161455);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xq xqVar) {
            AppMethodBeat.i(29368);
            xq xqVar2 = xqVar;
            if (xqVar2 != null) {
                if (!(xqVar2 instanceof xq)) {
                    Log.f("MicroMsg.TalkRoomServerListener", "mismatch %s", xqVar2.getClass().getName());
                } else if (xqVar2.edR.edU) {
                    com.tencent.mm.plugin.talkroom.model.b.ftN().fub();
                    AppMethodBeat.o(29368);
                    return true;
                } else if (!(!xqVar2.edR.edT || xqVar2.edS == null || com.tencent.mm.plugin.talkroom.model.b.ftN() == null)) {
                    xqVar2.edS.edV = com.tencent.mm.plugin.talkroom.model.b.ftN().FQv;
                    AppMethodBeat.o(29368);
                    return true;
                }
            }
            AppMethodBeat.o(29368);
            return false;
        }
    }

    class a extends IListener<xp> {
        private a() {
            AppMethodBeat.i(161452);
            this.__eventId = xp.class.getName().hashCode();
            AppMethodBeat.o(161452);
        }

        /* synthetic */ a(Plugin plugin, byte b2) {
            this();
            AppMethodBeat.i(161453);
            this.__eventId = xp.class.getName().hashCode();
            AppMethodBeat.o(161453);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xp xpVar) {
            AppMethodBeat.i(29367);
            xp xpVar2 = xpVar;
            if (!(xpVar2 instanceof xp)) {
                Log.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", xpVar2.getClass().getName());
            } else if (xpVar2.edP.edQ) {
                com.tencent.mm.plugin.talkroom.model.b.ftQ().FPZ = 1;
                AppMethodBeat.o(29367);
                return true;
            }
            AppMethodBeat.o(29367);
            return false;
        }
    }

    class c extends IListener<xs> {
        private c() {
            AppMethodBeat.i(161456);
            this.__eventId = xs.class.getName().hashCode();
            AppMethodBeat.o(161456);
        }

        /* synthetic */ c(Plugin plugin, byte b2) {
            this();
            AppMethodBeat.i(161457);
            this.__eventId = xs.class.getName().hashCode();
            AppMethodBeat.o(161457);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xs xsVar) {
            AppMethodBeat.i(29369);
            xs xsVar2 = xsVar;
            if (!(xsVar2 instanceof xs)) {
                Log.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", xsVar2.getClass().getName());
            }
            AppMethodBeat.o(29369);
            return false;
        }
    }
}
