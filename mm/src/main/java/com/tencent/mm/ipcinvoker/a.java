package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a]\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"ipcInvoke", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "targetProcessName", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "process", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lkotlin/jvm/functions/Function1;)V", "ipcinvoker_release"})
public final class a {
    public static final <InputType extends Parcelable, ResultType extends Parcelable> void a(String str, InputType inputtype, b<InputType, ResultType> bVar, b<? super ResultType, x> bVar2) {
        C0352a aVar;
        AppMethodBeat.i(240211);
        p.h(str, "targetProcessName");
        p.h(bVar, "process");
        Class<?> cls = bVar.getClass();
        if (bVar2 == null) {
            aVar = null;
        } else {
            aVar = new C0352a(bVar2);
        }
        h.a(str, inputtype, cls, aVar);
        AppMethodBeat.o(240211);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, hxF = {"<anonymous>", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "data", "kotlin.jvm.PlatformType", "onCallback", "(Landroid/os/Parcelable;)V"})
    /* renamed from: com.tencent.mm.ipcinvoker.a$a  reason: collision with other inner class name */
    static final class C0352a<T> implements d<ResultType> {
        final /* synthetic */ b gWe;

        C0352a(b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(240210);
            Parcelable parcelable = (Parcelable) obj;
            b bVar = this.gWe;
            p.g(parcelable, "data");
            bVar.invoke(parcelable);
            AppMethodBeat.o(240210);
        }
    }
}
