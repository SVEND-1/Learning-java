package org.example.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockThread {
    public static void main(String[] args) {

    }

    static abstract class AbstractCounter{
        private long value;

        public final long getValue(){
            final Lock lock = this.getReadLock();
            lock.lock();
            try {
                return this.value;
            }finally {
                lock.unlock();
            }
        }

        public final long increment(){
            final Lock lock = this.getWriteLock();
            lock.lock();
            try {
                return this.value;
            }
            finally {
                lock.unlock();
            }
        }

        protected abstract Lock getReadLock();
        protected abstract Lock getWriteLock();
    }

    static class CounterGuardedByLock extends AbstractCounter{
        private final Lock lock = new ReentrantLock();

        @Override
        protected Lock getReadLock() {
            return this.lock;
        }

        @Override
        protected Lock getWriteLock() {
            return this.lock;
        }
    }

    static class CounterGuardedBYReadWriteLock extends AbstractCounter{
        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private final Lock readLock = readWriteLock.readLock();
        private final Lock writeLock = readWriteLock.writeLock();

        @Override
        protected Lock getReadLock() {
            return readLock;
        }

        @Override
        protected Lock getWriteLock() {
            return writeLock;
        }
    }
}
