package std.tetcoshvili.api.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.UserRepository;
import std.tetcoshvili.api.entity.sec.DotaUserPrincipal;
import std.tetcoshvili.api.entity.sec.User;

@Service
public class DotaUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public DotaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new DotaUserPrincipal(user);
    }
}
