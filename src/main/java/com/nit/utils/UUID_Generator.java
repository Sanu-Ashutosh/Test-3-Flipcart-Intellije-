package com.nit.utils;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.UUID;

public final class UUID_Generator implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    // Step 1: Singleton instance (optional, kept for edge case protections)
    private static final UUID_Generator INSTANCE = new UUID_Generator();

    // Step 2: Private constructor with reflection guard
    private UUID_Generator() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use static method generateId() — cannot instantiate utility class");
        }
    }

    // ✅ Step 3: Public static method — no instance required
    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }

    // ❌ Step 4: Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton is not allowed");
    }

    // ❌ Step 5: Prevent breaking via serialization
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    // ❌ Step 6: Prevent breaking via deserialization
    private Object readObjectNoData() throws ObjectStreamException {
        return INSTANCE;
    }
}
