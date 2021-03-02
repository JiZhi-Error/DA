package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.magicbrush.handler.glfont.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class l implements d {
    private d.a cNO = new d.a();
    private int cNP;
    private d.c cNQ = new d.c();
    private int mHeight;
    private ArrayList<d.b> mNodes = new ArrayList<>();
    private int mWidth;

    l() {
        AppMethodBeat.i(140057);
        AppMethodBeat.o(140057);
    }

    @Override // com.tencent.magicbrush.handler.glfont.d
    public final void init(int i2, int i3) {
        AppMethodBeat.i(140058);
        this.mWidth = i2;
        this.mHeight = i3;
        reset();
        AppMethodBeat.o(140058);
    }

    @Override // com.tencent.magicbrush.handler.glfont.d
    public final void a(int i2, int i3, Rect rect) {
        d.c cVar;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(140059);
        if (rect == null) {
            AppMethodBeat.o(140059);
        } else if (i2 <= 0 || i3 <= 0) {
            rect.setEmpty();
            AppMethodBeat.o(140059);
        } else {
            d.c cVar2 = this.cNQ;
            cVar2.x = 0;
            cVar2.y = 0;
            cVar2.width = i2;
            cVar2.height = i3;
            int i7 = -1;
            int i8 = 0;
            int i9 = Integer.MAX_VALUE;
            int i10 = Integer.MAX_VALUE;
            while (i8 < this.mNodes.size()) {
                d.b bVar = this.mNodes.get(i8);
                if (bVar.x + i2 <= this.mWidth - 1) {
                    int i11 = bVar.y;
                    int i12 = i8;
                    int i13 = i2;
                    while (true) {
                        if (i13 <= 0) {
                            i4 = i11;
                            break;
                        }
                        d.b bVar2 = this.mNodes.get(i12);
                        if (bVar2.y > i11) {
                            i11 = bVar2.y;
                        }
                        if (i11 + i3 > this.mHeight - 1) {
                            i4 = -1;
                            break;
                        } else {
                            i13 -= bVar2.z;
                            i12++;
                        }
                    }
                } else {
                    i4 = -1;
                }
                if (i4 >= 0) {
                    d.b bVar3 = this.mNodes.get(i8);
                    if (i4 + i3 < i10 || (i4 + i3 == i10 && bVar3.z > 0 && bVar3.z < i9)) {
                        i6 = bVar3.z;
                        cVar2.x = bVar3.x;
                        cVar2.y = i4;
                        i5 = i8;
                        i10 = i4 + i3;
                        i8++;
                        i7 = i5;
                        i9 = i6;
                    }
                }
                i5 = i7;
                i6 = i9;
                i8++;
                i7 = i5;
                i9 = i6;
            }
            if (i7 == -1) {
                cVar2.x = -1;
                cVar2.y = -1;
                cVar2.width = 0;
                cVar2.height = 0;
                cVar = cVar2;
            } else {
                d.b Ry = this.cNO.Ry();
                Ry.x = cVar2.x;
                Ry.y = cVar2.y + i3;
                Ry.z = i2;
                this.mNodes.add(i7, Ry);
                for (int i14 = i7 + 1; i14 < this.mNodes.size(); i14 = (i14 - 1) + 1) {
                    d.b bVar4 = this.mNodes.get(i14);
                    d.b bVar5 = this.mNodes.get(i14 - 1);
                    if (bVar4.x >= bVar5.x + bVar5.z) {
                        break;
                    }
                    int i15 = (bVar5.z + bVar5.x) - bVar4.x;
                    bVar4.x += i15;
                    bVar4.z -= i15;
                    if (bVar4.z > 0) {
                        break;
                    }
                    this.cNO.a(this.mNodes.remove(i14));
                }
                int i16 = 0;
                while (true) {
                    int i17 = i16;
                    if (i17 >= this.mNodes.size() - 1) {
                        break;
                    }
                    d.b bVar6 = this.mNodes.get(i17);
                    d.b bVar7 = this.mNodes.get(i17 + 1);
                    if (bVar6.y == bVar7.y) {
                        bVar6.z = bVar7.z + bVar6.z;
                        this.cNO.a(this.mNodes.remove(i17 + 1));
                        i17--;
                    }
                    i16 = i17 + 1;
                }
                this.cNP += i2 * i3;
                cVar = cVar2;
            }
            if (cVar.x < 0 || cVar.y < 0) {
                rect.setEmpty();
                AppMethodBeat.o(140059);
                return;
            }
            rect.set(cVar.x, cVar.y, (cVar.x + i2) - 1, (cVar.y + i3) - 1);
            AppMethodBeat.o(140059);
        }
    }

    @Override // com.tencent.magicbrush.handler.glfont.d
    public final void reset() {
        AppMethodBeat.i(140060);
        this.cNP = 0;
        this.cNO.e(this.mNodes);
        d.b Ry = this.cNO.Ry();
        Ry.im(this.mWidth - 2);
        this.mNodes.add(Ry);
        AppMethodBeat.o(140060);
    }
}
