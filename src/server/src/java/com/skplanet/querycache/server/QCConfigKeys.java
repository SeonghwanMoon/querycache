package com.skplanet.querycache.server;

public class QCConfigKeys {
  public static final String  QC_SERVER_PORT = "qc.server.port";
  public static final int     QC_SERVER_PORT_DEFAULT = 8655;
  public static final String  QC_WORKERTHREAD_MIN = "qc.workerthread.min";
  public static final int     QC_WORKERTHREAD_MIN_DEFAULT = 16;
  public static final String  QC_WORKERTHREAD_MAX = "qc.workerthread.max";
  public static final int     QC_WORKERTHREAD_MAX_DEFAULT = 64;
  public static final String  QC_CONNECTIONPOOL_FREE_INIT_SIZE = "qc.connpool.free.init.size";
  public static final int     QC_CONNECTIONPOOL_FREE_INIT_SIZE_DEFAULT = 16;
  public static final String  QC_CONNECTIONPOOL_FREE_RESIZING_F = "qc.connpool.free.resizing.factor";
  public static final float   QC_CONNECTIONPOOL_FREE_RESIZING_F_DEFAULT = 0.2f;
  public static final String  QC_CONNECTIONPOOL_RESIZING_CYCLE_MILLI = "qc.connpool.resizing.cycle.milli";
  public static final long    QC_CONNECTIONPOOL_RESIZING_CYCLE_MILLI_DEFAULT = 15 * 1000;
  public static final String  QC_CONNECTIONPOOL_GC_PREFIX = "qc.connpool.gc";
  public static final boolean QC_CONNECTIONPOOL_GC_DEFAULT = true;
  public static final String  QC_CONNECTIONPOOL_GC_CYCLE_MILLI = "qc.connpool.gc.cycle.milli";
  public static final long    QC_CONNECTIONPOOL_GC_CYCLE_MILLI_DEFAULT = 5 * 60 * 1000;
  public static final String  QC_CONNECTIONPOOL_GC_VERIFY_QUERY = "qc.connpool.gc.verify.query";
  public static final String  QC_CONNECTIONPOOL_GC_VERIFY_QUERY_DEFAULT = "show databases";
  public static final String  QC_QUERY_PROFILING_LEVEL = "qc.query.profiling.level";
  public static final int     QC_QUERY_PROFILING_LEVEL_DEFAULT = 0;
  public static final String  QC_QUERY_PROFILING_DETAIL_UPPER_MILLI = "qc.query.profiling.detail.upper.milli";
  public static final long    QC_QUERY_PROFILING_DETAIL_UPPER_MILLI_DEFAULT = 500;
  public static final String  QC_OBJECTPOOL_MAX_SIZE = "qc.objpool.max.size";
  public static final int     QC_OBJECTPOOL_MAX_SIZE_DEFAULT = 1024 * 1024;
  public static final String  QC_OBJECTPOOL_CELL_COEFF = "qc.objpool.cell.coeff";
  public static final int     QC_OBJECTPOOL_CELL_COEFF_DEFAULT = 2;
  public static final String  QC_OBJECTPOOL_RESIZING_CYCLE_MILLI = "qc.objpool.reload.cycle.milli";
  public static final long    QC_OBJECTPOOL_RESIZING_CYCLE_MILLI_DEFAULT = 15 * 1000;
  public static final String  QC_OBJECTPOOL_RESIZING_F = "qc.objpool.resizing.factor";
  public static final float   QC_OBJECTPOOL_RESIZING_F_DEFAULT = 0.2f;
  public static final String  QC_STORAGE_JDBC_DRIVERS = "qc.storage.jdbc.drivers";
  public static final String  QC_STORAGE_JDBC_DRIVERS_ADDRESS_PREFIX = "qc.storage.jdbc.drivers.address";
  public static final String  QC_STORAGE_JDBC_DRIVERS_PORT_PREFIX = "qc.storage.jdbc.drivers.port";
  public static final String  QC_STORAGE_JDBC_DRIVERS_PKGPATH_PREFIX = "qc.storage.jdbc.drivers.pkgpath";
  public static final String  QC_STORAGE_JDBC_DRIVERS_URLPREFIX_PREFIX = "qc.storage.jdbc.drivers.url.prefix";
  public static final String  QC_STORAGE_JDBC_DRIVERS_USER_PREFIX = "qc.storage.jdbc.drivers.user";
  public static final String  QC_STORAGE_JDBC_DRIVERS_PASSWORD_PREFIX = "qc.storage.jdbc.drivers.password";
  public static final String  QC_STORAGE_JDBC_DRIVERS_URLSUFFIX_PREFIX = "qc.storage.jdbc.drivers.url.suffix";
  public static final String  QC_STORAGE_AUTH_POLICY_FILE_PREFIX = "qc.storage.auth.policy.file";
  //default: org.apache.sentry.provider.file.LocalGroupResourceAuthorizationProvider
  public static final String  QC_STORAGE_AUTH_POLICY_PROVIDER_CLASS_PREFIX = "qc.storage.auth.policy.provider.class";
  public static final String  QC_STORAGE_AUTH_UDF_WHITELIST_FILE_PREFIX = "qc.storage.auth.udf.whitelist.file";
  public static final String  QC_STORAGE_HBASE_DRIVER = "qc.storage.hbase.driver";
  public static final String  QC_STORAGE_HBASE_DRIVER_ADDRESS_PREFIX = "qc.storage.hbase.drivers.address";
  public static final String  QC_STORAGE_HBASE_DRIVER_PORT_PREFIX = "qc.storage.hbase.drivers.port";
  public static final String  QC_STORAGE_HBASE_DRIVER_URLPREFIX_PREFIX = "qc.storage.hbase.drivers.url.prefix";
  public static final String  QC_STORAGE_HBASE_DRIVER_USER_PREFIX = "qc.storage.hbase.drivers.user";
  public static final String  QC_STORAGE_HBASE_DRIVER_PASSWORD_PREFIX = "qc.storage.hbase.drivers.password";
  public static final String  QC_STORAGE_HBASE_DRIVER_URLSUFFIX_PREFIX = "qc.storage.hbase.drivers.url.suffix";
  public static final String  QC_QUERY_SYNTAX_CHECK = "qc.query.syntax.check";
  public static final boolean QC_QUERY_SYNTAX_CHECK_DEFAULT = false;
  public static final String  QC_AUTHORIZATION_PREFIX = "qc.authorization";
  public static final String  QC_AUTHORIZATION_DEFAULT = "NONE";
  public static final String  QC_AUTHORIZATION_POLICY_RELOAD_CYCLE_MILLI = "qc.authorization.policy.reload.cycle.milli";
  public static final long    QC_AUTHORIZATION_POLICY_RELOAD_CYCLE_MILLI_DEFAULT = 5 * 60 * 1000;
  public static final String  QC_QUERY_PROFILE_COMPLETE_RETENTION_CNT = "qc.query.profile.complete.retention.count";
  public static final int     QC_QUERY_PROFILE_COMPLETE_RETENTION_CNT_DEFAULT = 50;
  public static final String  QC_THREADPOOL_INIT_SIZE = "qc.threadpool.init.size";
  public static final int     QC_THREADPOOL_INIT_SIZE_DEFAULT = 0;
  public static final String  QC_THREADPOOL_MAX_SIZE = "qc.threadpool.max.size";
  public static final int     QC_THREADPOOL_MAX_SIZE_DEFAULT = Integer.MAX_VALUE;
}
