package g.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    public final g.a.a.b.a.a UbS;
    private int UbT = 0;
    private final b unknownTagHandler;

    public a(byte[] bArr, b bVar) {
        AppMethodBeat.i(2399);
        this.UbS = new g.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
        AppMethodBeat.o(2399);
    }

    public final int hPk() {
        AppMethodBeat.i(168735);
        this.UbT = this.UbS.yT();
        int gY = g.a.a.b.a.gY(this.UbT);
        AppMethodBeat.o(168735);
        return gY;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void hPl() {
        AppMethodBeat.i(2403);
        int gX = g.a.a.b.a.gX(this.UbT);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(g.a.a.b.a.gY(this.UbT)).append(" - ");
        switch (gX) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.UbS.zl());
                break;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.UbS.zn())));
                AppMethodBeat.o(2403);
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.UbS.readString());
                AppMethodBeat.o(2403);
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.UbS.zm())));
                AppMethodBeat.o(2403);
                return;
        }
        AppMethodBeat.o(2403);
    }

    public final LinkedList<byte[]> awh(int i2) {
        AppMethodBeat.i(2404);
        LinkedList<byte[]> awh = this.UbS.awh(i2);
        AppMethodBeat.o(2404);
        return awh;
    }
}
