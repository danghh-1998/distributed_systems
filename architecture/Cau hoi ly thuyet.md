# Chương 2: Kiến trúc 

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Trong mô hình kiến trúc phân tầng OSI của Mạng máy tính, hãy trình bày tóm tắt chức năng của từng tầng. 

|        Tầng        | Chức năng                                                    |
| :----------------: | :----------------------------------------------------------- |
|   Physical layer   | Đảm bảo các yêu cầu truyền/nhận các chuỗi bit qua các phương tiện vật lý. |
|  Data link layer   | Tạo/gỡ bỏ khung thông tin (Frames), kiểm soát luồng và kiểm soát lỗi. |
|   Network layer    | Thực hiện chọn đường và đảm bảo trao đổi thông tin trong liên mạng với công nghệ chuyển mạch thích hợp. |
|  Transport layer   | Vận chuyển thông tin giữa các máy chủ (End to End). Kiểm soát lỗi và luồng dữ liệu. |
|   Session layer    | Quản lý các cuộc liên lạc giữa các thực thể bằng cách thiết lập, duy  trì, đồng bộ hóa và hủy bỏ các phiên truyền thông giữa các ứng dụng. |
| Presentation layer | Chuyển đổi cú pháp dữ liệu để đáp ứng yêu cầu truyền thông của các ứng dụng. |
| Application layer  | Giao tiếp người dùng và môi trường mạng.                     |

> Lấy ví dụ cụ thể khi chúng ta thay đổi /cập nhật một tầng bất kỳ thì không ảnh hưởng đến hoạt động của các tầng khác.

- Ví dụ khi ta thay đổi giao thức IPv4 sang IPv6 ở tầng mạng thì các người dùng không cần thay đổi trình duyệt hoặc các giao thức trên tầng ứng dụng hoặc không cần thay đổi các thiết bị phần cứng.

## Câu 2

> Cho ví dụ và phân tích một mô hình kiến trúc thuê bao /xuất bản (publish /subscribe)

- Ví dụ chức năng thông báo có video mới của Youtube, khi một video được tải lên Youtube, thay vì Youtube gửi thông báo cho các subcriber thì thông tin có video upload sẽ được đưa vào một message chanel sau đó sẽ gửi đến các user đã đăng ký kênh trước đó.

![pub_sub_flow](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2_md/architecture/images/pub_sub_flow.png)

## Câu 3

> Sự khác nhau giữa phân tán dọc và phân tán ngang là gì?

- Phân tán dọc: Các quan hệ được chia theo chiều dọc, các quan hệ mới chỉ chứa một số thuộc tính của quan hệ gốc, đây là phép chiếu trên tập con các thuộc tính của quan hệ.
- Phân tán ngang: Các quan hệ được chia theo chiều ngang, đây là phép chọn trong quan hệ thỏa mãn một điều kiện cho trước.

## Câu 4

> Phân tích ưu nhược điểm của kiến trúc tập trung và kiến trúc không tập trung.

|                           | Ưu điểm                                                      | Nhược điểm                                                   |
| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Kiến trúc tập trung       | Tốc độ truy cập dữ liệu nhanh, khả năng mở rộng cao, đáng tin cậy, độ an toàn cao. | Cần server riêng, dễ bị nghẽn cổ chai, phức tạp trfong bảo trì, duy trì hoạt động. |
| Kiến trúc không tập trung | Không cần server riêng, mạng càng lớn thì khả năng chia sẻ tài nguyên càng tốt, rẻ, dễ cài đặt, bảo trì. | Chậm, độ an toàn không cao.                                  |

## Câu 5

> Trong một mạng overlay có cấu trúc, các thông điệp được định tuyến dựa theo hình trạng mạng (topology). Nhược điểm quan trọng của hướng tiếp cận này là gì? 

- Nhược điểm của hướng tiếp cận này là độ trễ mạng, khi số hops trên đường truyền tăng lên, số lượng hàng xóm tối đa tăng lên thì việc duy trì mạng trở nên khó khăn hơn.

## Câu 6

> Xét một chuỗi các tiến trình P1, P2, ..., Pn triển khai một kiến trúc client-server đa tầng. Cơ chế hoạt động của tổ chức đó như sau: tiến trình Pi là client của tiến trình Pi+1, và Pi sẽ trả lời Pi-1 chỉ khi đã nhận được câu trả lời từ Pi+1. Vậy những vấn đề nào sẽ nảy sinh với tổ chức này khi xem xét hiệu năng yêu cầu-trả lời tới P1?

- Đối với kiến trúc client-server đa tầng theo chuỗi tiến trình. Ta cần xem xét vấn đề khi một tiến trình không nhận được phản hồi từ tiến trình trước đó thì hệ thống sẽ ngừng hoạt động. Ta có thể cải thiện bằng cách tổ chức song song các tiến trình.

## Câu 7

> Xét mạng CAN như trong hình. Giả sử tất cả các node đều biết node hàng xóm của mình. Một giải thuật định tuyến được đưa ra đó là gửi các gói tin cho node hàng xóm gần mình nhất và hướng đến đích. Giải thuật này có tốt không? Giải thích.

- Trong mạng CAN, các node trong mạng sẽ duy trì thông tin định tuyến với các node hàng xóm của nó, là các node có vùng quản lý tiếp giáp với nhau. Các node hàng xóm này sẽ liên lạc với nhau để định tuyến tìm tới các node lưu giữ khóa ở xa. Vì vậy giải thuật định tuyến gửi các gói tin cho node hàng xóm gần mình nhất và hướng đến đich là phù hợp.