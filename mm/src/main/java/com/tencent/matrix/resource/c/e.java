package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e extends d {
    final OutputStream cZh;
    final ByteArrayOutputStream cZi = new ByteArrayOutputStream();
    int coW = 0;

    public e(OutputStream outputStream) {
        super(null);
        this.cZh = outputStream;
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(String str, int i2, long j2) {
        if (i2 <= 0 || i2 >= 1073741823) {
            try {
                throw new IOException("bad idSize: ".concat(String.valueOf(i2)));
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } else {
            this.coW = i2;
            OutputStream outputStream = this.cZh;
            outputStream.write(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            outputStream.write(0);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i2);
            com.tencent.matrix.resource.c.b.a.a(this.cZh, j2);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(b bVar, String str, int i2, long j2) {
        try {
            this.cZh.write(1);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, (int) j2);
            this.cZh.write(bVar.cZp);
            this.cZh.write(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)), 0, str.length());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(int i2, b bVar, int i3, b bVar2, int i4, long j2) {
        try {
            this.cZh.write(2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i4);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, (int) j2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i2);
            this.cZh.write(bVar.cZp);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i3);
            this.cZh.write(bVar2.cZp);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(b bVar, b bVar2, b bVar3, b bVar4, int i2, int i3, int i4, long j2) {
        try {
            this.cZh.write(4);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i4);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, (int) j2);
            this.cZh.write(bVar.cZp);
            this.cZh.write(bVar2.cZp);
            this.cZh.write(bVar3.cZp);
            this.cZh.write(bVar4.cZp);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i3);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(int i2, int i3, b[] bVarArr, int i4, long j2) {
        try {
            this.cZh.write(5);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i4);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, (int) j2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i3);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, bVarArr.length);
            for (b bVar : bVarArr) {
                this.cZh.write(bVar.cZp);
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public a b(int i2, int i3, long j2) {
        try {
            return new a(i2, i3, j2);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void a(int i2, int i3, long j2, byte[] bArr) {
        try {
            this.cZh.write(i2);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, i3);
            com.tencent.matrix.resource.c.b.a.b(this.cZh, (int) j2);
            this.cZh.write(bArr, 0, (int) j2);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.tencent.matrix.resource.c.d
    public final void Td() {
        try {
            this.cZh.flush();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends b {
        private final int cZj;
        private final long cZk;
        private final int mTag;

        a(int i2, int i3, long j2) {
            super(null);
            this.mTag = i2;
            this.cZj = i3;
            this.cZk = j2;
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(int i2, b bVar) {
            try {
                e.this.cZi.write(254);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                e.this.cZi.write(bVar.cZp);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void b(int i2, b bVar) {
            try {
                e.this.cZi.write(i2);
                e.this.cZi.write(bVar.cZp);
                if (i2 == 1) {
                    com.tencent.matrix.resource.c.b.a.b(e.this.cZi, (long) e.this.coW);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(b bVar, int i2, int i3) {
            try {
                e.this.cZi.write(2);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void b(b bVar, int i2, int i3) {
            try {
                e.this.cZi.write(3);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(b bVar, int i2) {
            try {
                e.this.cZi.write(4);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void b(b bVar, int i2) {
            try {
                e.this.cZi.write(6);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void c(b bVar, int i2, int i3) {
            try {
                e.this.cZi.write(8);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(b bVar, int i2, b bVar2, b bVar3, int i3, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
            try {
                e.this.cZi.write(32);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                e.this.cZi.write(bVar2.cZp);
                e.this.cZi.write(bVar3.cZp);
                com.tencent.matrix.resource.c.b.a.b(e.this.cZi, (long) (e.this.coW << 2));
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
                com.tencent.matrix.resource.c.b.a.a((OutputStream) e.this.cZi, 0);
                com.tencent.matrix.resource.c.b.a.a((OutputStream) e.this.cZi, aVarArr.length);
                for (com.tencent.matrix.resource.c.a.a aVar : aVarArr) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.cZi, aVar.cZn);
                    e.this.cZi.write(aVar.cZm);
                    ByteArrayOutputStream byteArrayOutputStream = e.this.cZi;
                    Object obj = aVar.cZo;
                    if (obj == null) {
                        throw new IllegalArgumentException("value is null.");
                    }
                    if (obj instanceof b) {
                        com.tencent.matrix.resource.c.b.a.a(byteArrayOutputStream, (b) obj);
                    } else if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
                        byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
                    } else if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a((OutputStream) byteArrayOutputStream, (int) ((Character) obj).charValue());
                    } else if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b((OutputStream) byteArrayOutputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
                    } else if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(byteArrayOutputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    } else if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
                        byteArrayOutputStream.write(((Byte) obj).byteValue());
                    } else if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a((OutputStream) byteArrayOutputStream, (int) ((Short) obj).shortValue());
                    } else if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b((OutputStream) byteArrayOutputStream, ((Integer) obj).intValue());
                    } else if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(byteArrayOutputStream, ((Long) obj).longValue());
                    } else {
                        throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
                    }
                }
                com.tencent.matrix.resource.c.b.a.a((OutputStream) e.this.cZi, aVarArr2.length);
                for (com.tencent.matrix.resource.c.a.a aVar2 : aVarArr2) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.cZi, aVar2.cZn);
                    e.this.cZi.write(aVar2.cZm);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(b bVar, int i2, b bVar2, byte[] bArr) {
            try {
                e.this.cZi.write(33);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                e.this.cZi.write(bVar2.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, bArr.length);
                e.this.cZi.write(bArr);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(b bVar, int i2, int i3, b bVar2, byte[] bArr) {
            try {
                e.this.cZi.write(34);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
                e.this.cZi.write(bVar2.cZp);
                e.this.cZi.write(bArr, 0, e.this.coW * i3);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void a(int i2, b bVar, int i3, int i4, int i5, byte[] bArr) {
            try {
                e.this.cZi.write(i2);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i4);
                e.this.cZi.write(i5);
                e.this.cZi.write(bArr, 0, c.iu(i5).getSize(e.this.coW) * i4);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void d(b bVar, int i2, int i3) {
            try {
                e.this.cZi.write(TbsListener.ErrorCode.NEEDDOWNLOAD_3);
                e.this.cZi.write(bVar.cZp);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i2);
                com.tencent.matrix.resource.c.b.a.b((OutputStream) e.this.cZi, i3);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.tencent.matrix.resource.c.b
        public final void Td() {
            try {
                e.this.cZh.write(this.mTag);
                com.tencent.matrix.resource.c.b.a.b(e.this.cZh, this.cZj);
                com.tencent.matrix.resource.c.b.a.b(e.this.cZh, e.this.cZi.size());
                e.this.cZh.write(e.this.cZi.toByteArray());
                e.this.cZi.reset();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }
}
