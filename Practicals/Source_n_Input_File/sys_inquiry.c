#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/utsname.h>

int main(void) {
    struct utsname sys_info;

    if (uname(&sys_info) != 0) {
        perror("uname failure");
        return EXIT_FAILURE;
    }

    long num_cores = sysconf(_SC_NPROCESSORS_ONLN);
    long page_size = sysconf(_SC_PAGESIZE);
    long total_pages = sysconf(_SC_PHYS_PAGES);
    
    // Calculate total RAM in Megabytes
    long long total_ram_mb = ((long long)page_size * total_pages) / (1024 * 1024);

    printf("==================================================\n");
    printf("        HTCondor Node Hardware & OS Report        \n");
    printf("==================================================\n");
    printf("Host Name:         %s\n", sys_info.nodename);
    printf("OS Kernel:         %s\n", sys_info.sysname);
    printf("OS Release:        %s\n", sys_info.release);
    printf("Architecture:      %s\n", sys_info.machine);
    printf("Assigned Process ID: %d\n", getpid());
    printf("Available CPU Cores: %ld\n", num_cores);
    printf("Total Physical RAM:  %lld MB\n", total_ram_mb);
    printf("==================================================\n");

    return EXIT_SUCCESS;
}
