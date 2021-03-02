package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

public abstract class j {
    public static final j aGZ = new j() {
        /* class com.bumptech.glide.load.b.j.AnonymousClass1 */

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oP() {
            return true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oQ() {
            return true;
        }
    };
    public static final j aHa = new j() {
        /* class com.bumptech.glide.load.b.j.AnonymousClass2 */

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oP() {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oQ() {
            return false;
        }
    };
    public static final j aHb = new j() {
        /* class com.bumptech.glide.load.b.j.AnonymousClass3 */

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(a aVar) {
            return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oP() {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oQ() {
            return true;
        }
    };
    public static final j aHc = new j() {
        /* class com.bumptech.glide.load.b.j.AnonymousClass4 */

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oP() {
            return true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oQ() {
            return false;
        }
    };
    public static final j aHd = new j() {
        /* class com.bumptech.glide.load.b.j.AnonymousClass5 */

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean a(boolean z, a aVar, c cVar) {
            return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oP() {
            return true;
        }

        @Override // com.bumptech.glide.load.b.j
        public final boolean oQ() {
            return true;
        }
    };

    public abstract boolean a(a aVar);

    public abstract boolean a(boolean z, a aVar, c cVar);

    public abstract boolean oP();

    public abstract boolean oQ();
}
