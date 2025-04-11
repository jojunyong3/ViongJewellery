



const sidebarMenu = [
  {
    label: '대시보드',
    icon: '🏠',
    link: '/v1/admin'
  },
  {
    label: '시세 관리',
    icon: '📊',
    link: '/v1/admin/metal-prices'
  },
  {
    label: '사용자 관리',
    icon: '👥',
    children: [
      { label: '직원 관리', link: '/admin/users/staff' },
      { label: '고객 관리', link: '/admin/users/customers' },
      { label: '권한 설정', link: '/admin/users/roles' }
    ]
  },
  {
    label: '재고 관리',
    icon: '📦',
    children: [
      { label: '입고 내역', link: '/admin/inbound' },
      { label: '출고 내역', link: '/admin/outbound' },
      { label: '현재 재고', link: '/admin/stock' }
    ]
  },
  {
    label: '월별 실적',
    icon: '📊',
    link: '/admin/statistics/monthly'
  },
  {
    label: '관리자 가이드',
    icon: '📘',
    link: '/admin/guide'
  }
];

function createSidebar(menu, containerId) {
  const container = document.getElementById(containerId);
  const ul = document.createElement('ul');
  ul.className = 'flex flex-col space-y-1';

  menu.forEach((item, idx) => {
    if (item.children) {
      const accId = `acc-${idx}`;
      const subId = `${accId}-child`;

      const li = document.createElement('li');
      li.className = 'hs-accordion';
      li.id = accId;
      li.innerHTML = `
        <button type="button"
          class="hs-accordion-toggle w-full text-start flex items-center gap-x-3.5 py-2 px-2.5 text-sm text-gray-800 rounded-lg hover:bg-gray-100 dark:text-neutral-200 dark:bg-neutral-800 dark:hover:bg-neutral-700"
          aria-expanded="false" aria-controls="${subId}">
          <span>${item.icon}</span>${item.label}
          <svg class="hs-accordion-active:block ms-auto hidden size-4" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="m18 15-6-6-6 6" /></svg>
          <svg class="hs-accordion-active:hidden ms-auto block size-4" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="m6 9 6 6 6-6" /></svg>
        </button>
        <div id="${subId}" class="hs-accordion-content w-full overflow-hidden transition-[height] duration-300 hidden" role="region">
          <ul class="ps-8 pt-1 space-y-1">
            ${item.children.map(child => `
              <li>
                <a href="${child.link}" class="flex items-center gap-x-3.5 py-2 px-2.5 text-sm text-gray-800 rounded-lg hover:bg-gray-100 dark:text-neutral-200 dark:hover:bg-neutral-700">
                  ${child.label}
                </a>
              </li>
            `).join('')}
          </ul>
        </div>
      `;

      ul.appendChild(li);
    } else {
      const li = document.createElement('li');
      li.innerHTML = `
        <a href="${item.link}" class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm text-gray-800 hover:bg-gray-100 rounded-lg dark:text-neutral-200 dark:hover:bg-neutral-700">
          <span>${item.icon}</span>${item.label}
        </a>
      `;
      ul.appendChild(li);
    }
  });

  container.appendChild(ul);
}

// DOM 생성 후 실행
document.addEventListener('DOMContentLoaded', () => {
  createSidebar(sidebarMenu, 'sidebar-menu');

  // Preline 초기화
  if (window.HSStaticMethods?.autoInit) {
    window.HSStaticMethods.autoInit();
  }
});
