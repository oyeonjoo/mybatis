package ch02.ex01;

import java.util.List;

import ch02.domain.User;

public interface Map {
	List<User> selectUsers(); // List Ÿ������ ����
}
// �������� �����͸� ������ �����ðŸ� ���� selectUsers
// configuration �������� getMapper(arg) ���� ��ȣ�ȿ� ch02.ex01 ġ�� �� �������̽� ȣ�Ⱑ��
// ������� �صθ� ���̹�Ƽ���� �˾Ƽ� �Ѵ�. �����ӿ�ũ ����.