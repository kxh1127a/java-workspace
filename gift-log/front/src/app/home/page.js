// app/gift-record/page.tsx (서버 컴포넌트)
import GiftPage from './GiftPage';

export default async function GiftRecordPage() {
    const giftRes = await fetch('http://localhost:8080/api/gift', { cache: 'no-store' }); // cache: 'no-store' 항상 새로운 데이터 요청
    const personRes = await fetch('http://localhost:8080/api/person', { cache: 'no-store' });

    const giftData = await giftRes.json();
    const personData = await personRes.json();

    return (
        <GiftPage giftData={giftData} personData={personData} />
    );
}
