# Chương 2: Kiến trúc

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## 1. Kiến trúc microservices

### Câu  2

> Vào trang web DockerHub và đăng nhập vào tài khoản của bạn. Bạn thấy những gì mới xuất hiện trên docker hub repository của bạn?

Ta thấy có 4 image với tag latest tương ứng với 4 docker image ta đã build ở local.

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2_md/architecture/images/dockerhub.png)

### Câu 3

> Trạng thái (status) của các pods vừa mới tạo được là gì? Bây giờ, hãy chờ vài phút và gõ lại lệnh đó, trạng thái mới của các pods giờ đã chuyển thành gì?

- Trạng thái các pods mới tạo ra là __completed__.

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2_md/architecture/images/pending.png)

- Sau khi chờ một thời gian trạng thái các pods chuyển thành __running__.

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2_md/architecture/images/running.png)

## 2. Kiến trúc JMS và DDS

### Câu 1

> Giải thích vai trò application server glashfish.

- Glassfish đóng vai trò là server để publisher và subscriber kết nối đến, quản lý các tài nguyên __myTopicConnectionFactory__ và __myTopic__, khi có yêu cầu publish message thì gửi message đó đến các subscriber đã đăng ký.

### Câu 2

> Tại sao lại phải tạo 2 JNDI như trên?

- Tạo resource __myTopic__ thuộc kiểu javax.jms.Topic đây là nơi publisher kết nối đến để publish message vá các subscriber sẽ nhận được message từ topic này.
- Tạo resource __myTopicConnectionFactory__ thuộc kiểu javax.jms.TopicConnectionFactory là đối tượng quản lý topic __myTopic__.

### Câu 3

> Sau khi chạy thử chương trình Sender và Receiver, vận dụng lý thuyết kiến trúc hướng sự kiện đã học trên lớp để giải thích cơ chế chuyền và nhận thông điệp của Sender và Receiver.

- Sender và Receiver đều tạo kết nối đến topic __myTopic__ thông qua __myTopicConnectionFactory__, đảm bảo Sender và Receiver có thể giao tiếp với nhau.
- Sender gửi message vào topic __myTopic__, thông qua server glassfish message này sẽ được gửi đến tất cả các Receiver nào đang kết nối đến __myTopic__.

