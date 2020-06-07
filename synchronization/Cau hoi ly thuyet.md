# Chương 6: Đồng bộ hóa

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Trình bày 1 ví dụ để mô phỏng vấn đề gặp phải khi các máy tính/tiến trình hoạt động trong hệ thống phân tán mà không có đồng hộ vật lý dùng chung.

Ví dụ như trong một trò chơi thời gian thực như CS:GO hay League of Legends chẳng hạn. Trong trò chơi, người chơi liên tục nhấn các tổ hợp phím hay sử dụng chuột, nếu không sử dụng đồng hồ chung thì server sẽ không thể xác định đâu là hành động được thực hiện trước, hành động nào thực hiện sau.

## Câu 2

> Tại sao Lamport lại đề xuất sử dụng đồng hồ logic thay cho đồng hồ vật lý trong hệ phân tán?

Các tiến trình trong thực tế có thể chỉ cần khớp với nhau về thời gian chứ không cần thiết phải đúng với thời gian thực tế, do vậy Lamport đề xuất sử dụng đồng hồ logic thay cho đồng hồ vật lý.

## Câu 3

> Đặc điểm gì của mạng không dây (wireless network) khiến cho thiết kế các giải thuật đồng bộ khác các kiểu mạng khác?

Mạng không dây hay wireless network có độ trễ mạng khi truyền các gói tin do vậy phải thiết kế các giải thuật đồng bộ riêng.

## Câu 4

> Giải thuật Lamport được đưa ra để thực hiện loại trừ lẫn nhau (mutual exclusion). Giải thuật được mô tả như sau:
> Hệ thống có n tiến trình: P1, P2, ... Pn. Có 1 tài nguyên chia sẻ dùng chung gọi là SR (Shared Resource). Mỗi tiến trình sẽ lưu trữ một hàng đợi queuei để lưu các yêu cầu của các tiến trình khác khi chưa được thực hiện.
> Khi tiến trình Pi muốn truy cập vào SR, nó sẽ quảng bá 1 thông điệp REQUEST(tsi,i) cho tất cả các tiến trình khác, đồng thời lưu trữ thông điệp đó vào hàng đợi của mình (queuei) trong đó tsi là timestamp của yêu cầu.
> Khi 1 tiến trình Pj nhận được yêu cầu REQUEST(tsi,i) từ tiến trình Pi thì nó đưa yêu cầu đó vào hàng đợi của mình (queuej) và gửi trả lại cho Pi thông điệp REPLY.
> Tiến trình Pi sẽ tự cho phép mình sử dụng SR khi nó kiểm tra thấy yêu cầu của nó nằm ở đầu hàng đợi queuei và các yêu cầu khác đều có timestamp lớn hơn yêu cầu của chính nó.
> Tiến trình Pi, khi không dùng SR nữa sẽ xóa yêu cầu của nó khỏi hàng đợi và quảng bá thông điệp RELEASE cho tất cả các tiến trình khác.
> Khi tiến trình Pj nhận được thông điệp RELEASE từ Pi thì nó sẽ xóa yêu cầu của Pi trong hàng đợi của nó.
> **Câu hỏi:**
> a. Để thực hiện thành công 1 tiến trình vào sử dụng SR, hệ thống cần tổng cộng bao nhiêu thông điệp?
> b. Có 1 cách cải thiện thuật toán trên như sau: sau khi Pj gửi yêu cầu REQUEST cho các tiến trình khác thì
> nhận được thông điệp REQUEST từ Pi, nếu nó nhận thấy rằng timestamp của REQUEST nó vừa gửi lớn
> hơn timestamp của REQUEST của Pi, nó sẽ không gửi thông điệp REPLY cho Pi nữa.
> Cải thiện trên có đúng hay không? Và với cải thiện này thì tổng số thông điệp cần để thực hiện thành
> công 1 tiến trình vào sử dụng SR là bao nhiêu? Giải thích.

a. Cần ba loại thông điệp REQUEST(tsi, i), REPLY và RELEASE. Khi có n tiến trình, để sử dụng thành công một tiến trình vào sử dụng SR, một tiến trình cần gửi (n-1) thông điệp REQUEST, các tiến trình còn lại sẽ gửi (n-1) thông điệp REPLY và sau khi không dung SR nữa tiến trình này sẽ gửi (n-1) thông điệp RELEASE cho các tiến trình khác. Vậy cần 3(n-1) thông điệp.

b, Phương pháp trên có thể cải thiên được thuật toán vì sẽ giảm thiểu được số thông điệp REPLY các tiến trình khác gửi trả về cho tiến trình gửi REQUEST bằng cách so sánh timestamp.

## Câu 5

> Giải thuật Szymanski được thiết kế để thực hiện loại trừ lẫn nhau. Ý tưởng của giải thuật đó là xây dựng một phòng chờ (waiting room) và có đường ra và đường vào, tương ứng với cổng ra và cổng vào. Ban đầu cổng vào sẽ được mở, cổng ra sẽ đóng. Nếu có một nhóm các tiến trình cùng yêu cầu muốn được sử dụng tài nguyên chung SR (shared resource) thì các tiến trình đó sẽ được xếp hàng ở cổng vào và lần lượt vào phòng chờ. Khi tất cả đã vào phòng chờ rồi thì tiến trình cuối cùng vào phòng sẽ đóng cổng vào và mở cổng ra. Sau đó các tiến trình sẽ lầnlượt được sử dụng tài nguyên chung. Tiến trình cuối cùng sử dụng tài nguyên sẽ đóng cổng ra và mở lại cổng vào.
> Mỗi tiến trình Pi sẽ có 1 biến flag i , chỉ tiến trình Pi mới có quyền ghi, còn các tiến trình Pj (j ≠ i) thì chỉ đọc được. Trạng thái mở hay đóng cổng sẽ được xác định bằng việc đọc giá trị flag của các tiến trình khác. Mã giả của thuật toán đối với tiến trình i được viết như sau:
>
> ```txt
> #Thực hiện vào phòng đợi
> flag[i] ← 1
> await(all flag[1..N] ∈ {0,1,2})
> flag[i] ← 3
> ifany flag[1..N]=1:
> flag[i] ← 2
> await(any flag[1..N]=4)
> flag[i] ← 4
> await(all flag[1..i-1] ∈ {0,1})
> #Sử dụng tài nguyên
> #...
> #Thực hiện giải phóng tài nguyên
> await(all flag[i+1..N] ∈ {0,1,4})
> flag[i] ← 0
> ```
>
> Giải thích ký pháp trong thuật toán:
> await(điều_kiện): chờ đến khi thỏa mãn điều_kiện
> all: tất cả
> any: có bất kỳ 1 cái nào
> **Câu hỏi:**
> flag[i] sẽ có 5 giá trị trạng thái từ 0-4. Dựa vào giải thuật trên, 5 giá trị đó mang ý nghĩa tương
> ứng nào sau đây (có giải thích):
>
> - Chờ tiến trình khác vào phòng chờ
> - Cổng vào được đóng
> - Tiến trình i đang ở ngoài phòng chờ
> - Rời phòng, mở lại cổng vào nếu không còn ai trong phòng chờ
> - Đứng đợi trong phòng chờ

| Flag[i] |                         Ý nghĩa                          |                          Giải thích                          |
| :-----: | :------------------------------------------------------: | :----------------------------------------------------------: |
|    0    | Rời phòng, mở lại cổng nếu không còn ai trong phòng chờ. |                                                              |
|    1    |           Tiến trình i đang ở ngoài phòng chờ.           |                                                              |
|    2    |            Chờ tiến trình khác vào phòng chờ.            | Nếu có bất kỳ tiến trình nào đang ở ngoài (1) thì sẽ được vào phòng chờ và đổi sang gía trị 2. |
|    3    |                   Cổng vào được đóng.                    |       Sau khi tất cả các tiến trình đã vào phòng chờ.        |
|    4    |                Đứng đợi trong phòng chờ.                 |               Chờ để được sử dụng tài nguyên.                |

