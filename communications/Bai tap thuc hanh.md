# Chương 4: Trao đổi thông tin

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Đâu là đoạn code mà Server gán correlationID vào câu trả lời?

- Đoạn code mà Server gán correlationID vào câu trả lời là

```java
AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                        .Builder()
                        .correlationId(delivery.getProperties().getCorrelationId())
                        .build();
```

## Câu 2

> Dựa vào cả code của Client và Server để giải thích đâu là đoạn code mà Client gửi yêu cầu lên cho Server thông qua hàng đợi rpc_queue và tạo ra một hàng đợi mới để chờ câu trả lời của Server.

- Client gửi message lên server thông qua hàng đợi __rpc_queue__

```java
String requestQueueName = "rpc_queue";
channel.basicPublish("", requestQueueName, props, message.getBytes(StandardCharsets.UTF_8));
```

- Sau đó Client tạo hàng đợi mới để nhận response từ server

```java
final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);
```

## Câu 3

> Bây giờ hãy thử thêm một chút delay vào chương trình Server bằng cách thêm vào đoạn code sau ở dưới dòng: `response += fib(n);`
>
> ```java
> try {
> 	Thread.sleep(2000);
> } catch (InterruptedException _ignored) {
> 	Thread.currentThread().interrupt();
> }
> ```
>
> Chương trình Server sẽ ngủ 2s đối với mỗi request. Hãy dịch lại chương trình Server và chạy nó.
> Mở cùng lúc nhiều cửa sổ command và chạy nhiều chương trình Client trên đó cùng lúc.
>
> Cùng lúc đó mở một cửa sổ command khác và chạy dòng lệnh sau:
>
> ```bash
> sudo rabbitmqctl list_queues name messages_ready messages_unacknowledged
> ```
>
> Bạn nhận được kết quả hiển thị gì? Giải thích!

- Kết quả hiển thị khi chạy lệnh

![Rabitmq](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_4/communications/images/RabbitMQ.png)

- Giải thích: 
  - __message_ready__ là số message sẵn sàng để gửi cho clients, các message này đang đợi ở exchange sẵn sàng để đưa vào queue của client. Do ở đây ta chạy hai client nên sẽ có 1 message ở exchange và một message được đưa vào hàng đợi của client
  - __message_unacknowledged__ là số message đã gửi đến client nhưng chưa được xác nhận.

## Câu 4

> Địa chỉ IP của 2 máy là gì? Làm sao để ping nhau?

- Địa chỉ của máy làm server là `192.168.1.230`, địa chỉ máy làm client là `192.168.1.58`. Để ping nhau thì ta dùng lệnh ping. Ví dụ để ping đến máy server 1 giây 1 lần thì ta dùng lệnh `ping -t 1 192.168.1.230`

## Câu 5

> Bạn đã xem được video trên máy client chưa? Đánh giá chất lượng video mà bạn xem trên máy client.

- Có thể xem được video tuy nhiên chất lượng video kém, hay bị nhòe hình ,mất tiếng

## Câu 6

> Kết quả nhận được sau lệnh ping là gì? Bạn có thấy độ trễ đã tăng 100ms không?

- Kết quả nhận được khi ping đến server

![ping](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_4/communications/images/ping.png)

- Độ trễ tăng lên 100ms 

## Câu 7

> Hãy tắt chức năng sử dụng bộ đệm ở máy Client. Sau đó hãy đánh giá chất lượng của video nhận được ở máy Client. Bạn kết luận thế nào về ảnh hưởng của delay với dịch vụ truyền dòng video?

- Chất lượng video được cải thiện, giảm hiện tượng giật lag, kết luận tăng delay sẽ tăng chất lượng stream.

## Câu 9

> Hãy xem video ở client và đánh giá về độ ảnh hưởng của packet loss lên chất lượng dịch vụ truyền video. Thử tăng giá trị của tỷ lệ mất gói tin lên để thấy độ ảnh hưởng rõ nét hơn.

- Chất lượng video giảm đi khi tỷ lệ packet loss tăng lên.

## Câu 10

> Hãy xem video ở client và đánh giá về độ ảnh hưởng của việc biến đổi packet loss lên chất lượng dịch vụ truyền video. Thử tăng giá trị của tỷ lệ mất gói tin lên để thấy độ ảnh hưởng rõ nét hơn.

- Chất lượng video stream giảm đi khi tỷ lệ biến đổi gói tin tăng lên.

## Câu 11

> Hãy xem video ở client và đánh giá về độ ảnh hưởng của việc lặp gói tin lên chất lượng dịch vụ truyền video. Thử tăng giá trị của tỷ lệ lặp gói tin lên để thấy độ ảnh hưởng rõ nét hơn.

- Chất lượng video giảm đi khi dộ mất gói tin tăng lên.

## Câu 12

> Hãy xem video ở client và đánh giá về độ ảnh hưởng của việc đảo thứ tự gói tin lên chất lượng dịch vụ truyền video.

- Chất lượng video giảm đi khi đảo thứ tự gói tin.