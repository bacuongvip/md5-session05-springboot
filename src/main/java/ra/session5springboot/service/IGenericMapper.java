package ra.session5springboot.service;

public interface IGenericMapper <T,K,V>{
    T toEntity(K k);
    V toResponse(T t);
}
