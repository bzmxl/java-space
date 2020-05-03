```text
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/concurrent/ThreadPoolTaskExecutor.html
```

```text
能够执行13次，然后报错
curl http://127.0.0.1:9673/AbortPolicy/a

能够执行完50次，然后超出的任务是主线程帮忙执行的
curl http://127.0.0.1:9673/CallerRunsPolicy/a

能够调用50次，但是真正执行只有13次，不报错，任务会丢弃
执行前13个任务0-12
？？？-直接丢弃比较旧的任务
curl http://127.0.0.1:9673/DiscardOldestPolicy/a

能够调用50次，但是真正执行只有13次，不报错，任务会丢弃
也是执行前13个任务0-12
？？？-直接丢弃任务
curl http://127.0.0.1:9673/DiscardPolicy/a

ls
```
